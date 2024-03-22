package com.auth.ws.company.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class AppCompany {
    @Id
    @SequenceGenerator(name = "company_sequence", sequenceName = "company_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_sequence")
    private Long id;

    private String name;

    private String city;

    private String taxNo;

    private String about;

    public AppCompany(String name, String taxNo) {
        this.name = name;
        this.taxNo = taxNo;
    }

    public AppCompany() {

    }
}
