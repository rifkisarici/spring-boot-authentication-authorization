package com.auth.ws.candidate.entity;

import com.auth.ws.employer.entity.AppEmployer;
import com.auth.ws.user.entity.AppUser;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class AppCandidate {
    @Id
    @SequenceGenerator(name = "userCandidate_sequence", sequenceName = "userCandidate_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userCandidate_sequence")
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "app_User")
    //@OnDelete(action = OnDeleteAction.CASCADE)//bir user silindiğinde, silinecek
    private AppUser appUser;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "app_Employer")
    private AppEmployer appEmployer;

    private String name;

    private String surname;

    private String mail;

    private String phone;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    private String adress;

    private String url;

    private String about;



    public AppCandidate(String name, String surname, AppUser appUser) {
        this.appUser = appUser;
        this.name = name;
        this.surname = surname;
    }

    public AppCandidate() {

    }

    public AppCandidate(String name, String phone, String mail, String adress, String url, Date birthDate) {
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.adress = adress;
        this.url = url;
        this.birthDate = birthDate;
    }
}
