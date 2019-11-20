package com.example.demo.controller.form.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ErrorExampleForm {

    @NotBlank(message = "Username or password is incorrect")
    private String errorUsername;

    @NotBlank(message = "Username or password is incorrect")
    private String errorPassword;
}
