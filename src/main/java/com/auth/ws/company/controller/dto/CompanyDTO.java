package com.auth.ws.company.controller.dto;

import com.auth.ws.company.entity.AppCompany;
import lombok.Data;

@Data
public class CompanyDTO {
    private Long id;
    private String name;
    /*
    private String country;*/

    public CompanyDTO(AppCompany appCompany) {
        this.setId(appCompany.getId());
        this.setName(appCompany.getName());
    }

    public CompanyDTO(String name) {
        this.setId(-1L);
        this.setName(name);
    }
}
