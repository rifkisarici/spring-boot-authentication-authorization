package com.auth.ws.candidate.controller.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class AboutRegistration {
    @NotNull
    @Size(max = 255)
    private String about;
}
