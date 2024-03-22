package com.auth.ws.employer.entity;

import com.auth.ws.company.entity.AppCompany;
import com.auth.ws.user.entity.AppUser;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
public class AppEmployer {
    @Id
    @SequenceGenerator(name = "userEmployer_sequence", sequenceName = "userEmployer_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userEmployer_sequence")
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "app_User", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)//bir user silindiğinde, silinecek
    private AppUser appUser;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "companyId", nullable = false)
    private AppCompany company;

    private String name;


    public AppEmployer() {

    }

    public AppEmployer(String name, AppUser appUser, AppCompany appCompany) {
        this.company= appCompany;
        this.appUser= appUser;
        this.name = name;
    }
}
