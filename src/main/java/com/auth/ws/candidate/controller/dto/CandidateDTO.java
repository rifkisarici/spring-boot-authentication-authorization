package com.auth.ws.candidate.controller.dto;

import com.auth.ws.user.entity.AppUser;
import com.auth.ws.user.entity.enums.UserRole;
import lombok.Data;

@Data
public class CandidateDTO {
    private String username;
    private String surname;
    private UserRole userRole;

    public CandidateDTO(AppUser appUser) {
        this.username = appUser.getUsername();
        this.userRole = appUser.getUserRole();
    }

}
