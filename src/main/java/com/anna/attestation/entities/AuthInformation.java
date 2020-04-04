package com.anna.attestation.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
@Entity
@Table(name = "auth_information")
public class AuthInformation {

    @Id
    @Column(name = "login")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String login;

    @Column(name = "password")
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
