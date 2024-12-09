package Mp.example.demoM.payload.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

    @NotBlank(message = "Le nom ne peut pas être vide.")
    private String email;

    @NotBlank(message = "password est obligatory.")
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
