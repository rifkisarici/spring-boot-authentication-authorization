package com.auth.ws.candidate.controller.dto;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class CandidateRegistrationDTO {
    /*@NotNull(message = "{auth.username.NotNull.message}")
    @UniqueUsername
    @Size(min = 3, max = 255)
    private String username;*/

    @NotNull
    @Size(min = 3, max = 255)
    private String name;

    /*@NotNull
    @Size(min = 3, max = 255)
    private String surname;*/

    private String mail;

    private String url;

    private String phone;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    private String adress;

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


    /*public AppUser getDomainAppUser() {
        return new AppUser(username, password, userRole);
    }*/

   /* public AppCandidate getDomainCandidate(AppUser appUser) {
        return new AppCandidate(name, surname, appUser);
    }*/


   /* public CandidateRegistrationDTO getDomainCandidate(Json json) {
        return new AppCandidate(json.jsonObject.getString(name), json.jsonObject.getString(surname), appUser);
    }*/
}
