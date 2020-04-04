package com.anna.attestation.entities;
import javax.persistence.*;

@Entity
@Table(name = "user_information")
public class User {

    @Id
    @Column(name = "login")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String login;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column(name = "role")
   // @OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "role_role", referencedColumnName = "role")
    private Integer role;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User login: " + this.getLogin() + "\n"+
               "User role: " + this.getRole() + "\n"+
               "User name: " + this.getFirstName() + "\n"+
               "User last name: " + this.getLastName() + "\n"+
               "User email: " + this.getEmail() + "\n"+
               "User phone: " + this.getPhoneNumber() + "\n";
    }
}
