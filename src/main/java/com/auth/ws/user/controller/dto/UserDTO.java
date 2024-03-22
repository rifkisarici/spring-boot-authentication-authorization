package com.auth.ws.user.controller.dto;

import com.auth.ws.user.entity.AppUser;
import com.auth.ws.user.entity.enums.UserRole;
import lombok.Data;

@Data
public class UserDTO {

    private String username;
    private UserRole userRole;

   /* @NotNull
    private String email;

    @NotNull
    @Size(min = 4, max = 255)
    private String firstName;
    */


    public UserDTO(AppUser appUser) {
        this.username = appUser.getUsername();
        this.userRole = appUser.getUserRole();
    }
}
