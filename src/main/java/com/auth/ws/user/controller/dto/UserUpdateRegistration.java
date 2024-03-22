package com.auth.ws.user.controller.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserUpdateRegistration {
    @NotBlank
    private String surname;
    private String username;
}
