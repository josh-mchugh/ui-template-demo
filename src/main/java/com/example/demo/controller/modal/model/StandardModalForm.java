package com.example.demo.controller.modal.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class StandardModalForm {

    @NotBlank
    private String username;
    @NotBlank
    private String firstName;
    @NotBlank
    private String middleName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String email;
    @NotBlank
    private String confirmEmail;
    @NotBlank
    private String password;
    @NotBlank
    private String confirmPassword;
}
