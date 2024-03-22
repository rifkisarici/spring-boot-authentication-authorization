package com.auth.ws.employer.controller.dto;

import com.auth.ws.user.entity.AppUser;
import com.auth.ws.user.entity.enums.UserRole;
import lombok.Data;

@Data
public class EmployerDTO {
    private Long id;
    private String username;
    private UserRole userRole;
    private String name;
    private String taxNo;

    public EmployerDTO(AppUser appUser) {
        this.username = appUser.getUsername();
        this.userRole = appUser.getUserRole();
        this.id = appUser.getId();
    }
}
