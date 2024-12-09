package Mp.example.demoM.security;

import Mp.example.demoM.services.UserDetailsImpl;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class JwtUtils {
    private SecretKey jwtSecretKey;

    @Value("${jwt.expirationMs}")
    private int jwtExpirationMs;

    // Constructor to initialize the SecretKey using the injected value
    public JwtUtils(@Value("${jwt.secret}") String jwtSecret) {
        // Ensure that the secret is 512 bits (64 bytes) for the HS512 algorithm
        if (jwtSecret.length() < 64) {
            throw new IllegalArgumentException("JWT secret must be at least 64 characters long for HS512");
        }


        this.jwtSecretKey = Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    // Generate JWT Token
    public String generateJwtToken(Authentication authentication) {
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        List<String> roles = userPrincipal.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .claim("roles", roles) // Add roles as a claim in the token
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(jwtSecretKey)
                .compact();
    }
    // Validate JWT Token
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(jwtSecretKey) // Use SecretKey for validation
                    .build()
                    .parseClaimsJws(authToken);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            System.out.println("Invalid JWT signature: " + e.getMessage());
        }
        return false;
    }

    // Get username from JWT Token
    public String getUsernameFromJwtToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(jwtSecretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject(); // Extract the username
    }

    // Get roles from JWT Token
    public List<String> getRolesFromJwtToken(String token) {
        return (List<String>) Jwts.parserBuilder()
                .setSigningKey(jwtSecretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("roles"); // Extract roles from
}


}
