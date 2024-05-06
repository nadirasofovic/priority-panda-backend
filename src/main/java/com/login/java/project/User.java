package com.login.java.project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private Long id;
    private String email;
    private String username;
    private String password;
    public User (){

    }
}
