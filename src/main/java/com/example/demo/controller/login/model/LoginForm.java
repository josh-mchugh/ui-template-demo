package com.example.demo.controller.login.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginForm {

    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
