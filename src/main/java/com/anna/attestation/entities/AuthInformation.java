package com.anna.attestation.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@AllArgsConstructor
@Entity
@Table(name = "auth_information")
public class AuthInformation {

    @Id
    @Column(name = "Login")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_login", referencedColumnName = "login")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String login;

    @Column(name = "Password")
    private String password;
}
