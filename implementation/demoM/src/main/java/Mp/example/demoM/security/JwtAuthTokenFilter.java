package Mp.example.demoM.security;

import Mp.example.demoM.services.UserDetailsServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class JwtAuthTokenFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            String jwt = parseJwt(request);
            if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
                // Extraire le nom d'utilisateur du token JWT
                String username = jwtUtils.getUsernameFromJwtToken(jwt);

                // Extraire les rôles du token JWT
                List<String> roles = jwtUtils.getRolesFromJwtToken(jwt);

                // Charger les détails de l'utilisateur en fonction du nom d'utilisateur
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                // Mapper les rôles vers des autorités (authorities)
                Object SimpleGrantedAuthority;
                List<GrantedAuthority> authorities = roles.stream()
                        .map(SimpleGrantedAuthority::new) // Convertir les rôles en GrantedAuthority
                        .collect(Collectors.toList());

                // Créer un token d'authentification utilisant les détails utilisateur et les rôles
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, authorities);

                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // Définir l'authentification dans le contexte de sécurité
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e) {
            logger.error("Impossible de définir l'authentification utilisateur : {}", e);
        }

        filterChain.doFilter(request, response);
    }

    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");

        if (headerAuth != null && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7);
        }

        return null;
}


}
