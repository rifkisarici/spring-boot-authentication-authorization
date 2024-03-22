package com.auth.ws.user.controller.dto;

import com.auth.ws.shared.annotations.validations.uniqueusername.UniqueUsername;
import com.auth.ws.user.entity.AppUser;
import com.auth.ws.user.entity.enums.UserRole;
import com.auth.ws.candidate.entity.AppCandidate;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserCandidateRegistrationDTO {
    @NotNull(message = "{auth.username.NotNull.message}")
    @UniqueUsername
    @Size(min = 3, max = 255)
    private String username;

    @NotNull
    @Size(min = 3, max = 255)
    private String name;

    @NotNull
    @Size(min = 3, max = 255)
    private String surname;

    @Enumerated(EnumType.STRING)
    @NotNull
    private UserRole userRole;


    /* @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$" ,message = "{auth.password.Pattern.message}")*/
    @Size(min = 3, max = 255)
    @NotNull
    private String password;


    /*//WsApplication başlarken, test için  hazır kullanıcı oluşturmak için
    public UserRegistrationDTO(String username, String surname, *//*String email, String firstName, String lastName,*//* String password, String userRole) {
        this.username = username;
        *//*this.email = email;
        this.firstName = firstName;*//*
        this.surname = surname;
        this.password = password;
        this.userRole = UserRole.valueOf(userRole);
        *//*this.userRole=userRole;*//*
    }*/


    public AppUser getDomainAppUser() {
        return new AppUser(username, password, userRole);
    }

    public AppCandidate getDomainAppUserCandidate(AppUser appUser) {
        return new AppCandidate(name, surname, appUser);
    }

}
