package com.auth.ws.user.controller.dto;

import com.auth.ws.company.entity.AppCompany;
import com.auth.ws.shared.annotations.validations.uniqueusername.UniqueUsername;
import com.auth.ws.user.entity.AppUser;
import com.auth.ws.user.entity.enums.UserRole;
import com.auth.ws.employer.entity.AppEmployer;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UserEmployerRegistrationDTO {
    @NotNull(message = "{auth.username.NotNull.message}")
    @UniqueUsername
    @Size(min = 3, max = 255)
    private String username;

    @NotNull
    @Size(min = 3, max = 255)
    private String name;

    @Enumerated(EnumType.STRING)
    @NotNull
    private UserRole userRole;

    /*@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$")*/
    @Size(min = 3, max = 255)
    @NotNull
    private String password;

    @NotNull
    @Size(min = 3, max = 255)
    private String companyName;

    @NotNull
    @Size(min = 10, max = 10)
    @Pattern(regexp = "\\d+$", message = "sadece rakam girebilirsiniz")
    private String taxNo;

    public AppUser getDomainAppUser() {
        return new AppUser(username, password, userRole);
    }

    public AppCompany getDomainAppCompany() {
        return new AppCompany(companyName, taxNo);
    }

    public AppEmployer getDomainAppEmployer(String name, AppUser appUser, AppCompany appCompany) {
        return new AppEmployer(name, appUser,appCompany);
    }


}
