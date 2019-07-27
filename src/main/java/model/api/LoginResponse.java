package model.api;

import lombok.Data;

@Data
public class LoginResponse {

    private String access_token;
    private String token_type;
    private Integer expires_in;
    private String scope;

}
