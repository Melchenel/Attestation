package com.anna.attestation.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "auth_information")
public class AuthInformation {

    @Id
    @Column(name = "login")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String login;

    @Column(name = "password")
    private String password;


    @Column(name = "code")
    private String code;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
