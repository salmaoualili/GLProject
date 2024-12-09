package Mp.example.demoM.payload.Response;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class JWTResponse {

    private String token;
    private String type = "Bearer";
    private Long id;
    private String username;
    private Set<String> roles;

    public void JwtResponse(String accessToken, Long id, String username, Set<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.roles =roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
