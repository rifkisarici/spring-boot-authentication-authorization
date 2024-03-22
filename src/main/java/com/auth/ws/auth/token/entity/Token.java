package com.auth.ws.auth.token.entity;

import com.auth.ws.user.entity.AppUser;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
public class Token {
    @Id
    private String token;

    @ManyToOne
    @JoinColumn(name = "APP_USER_ID", referencedColumnName = "ID", nullable = false)
    private AppUser appUser;

    public Token(String token, AppUser appUser) {
        this.token = token;
        this.appUser = appUser;
    }
}
