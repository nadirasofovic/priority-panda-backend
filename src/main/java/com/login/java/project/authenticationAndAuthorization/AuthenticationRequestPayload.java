package com.login.java.project.authenticationAndAuthorization;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequestPayload {
    private String username;
    private String password;
}