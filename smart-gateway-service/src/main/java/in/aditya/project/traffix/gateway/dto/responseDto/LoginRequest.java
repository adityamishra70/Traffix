package in.aditya.project.traffix.gateway.dto.responseDto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginRequest {

    private String username;
    private String password;
}