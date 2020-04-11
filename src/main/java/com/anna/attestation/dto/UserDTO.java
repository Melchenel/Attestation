package com.anna.attestation.dto;


public class UserDTO {

    private String login;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Integer role;

    public UserDTO(){

    }

    public UserDTO(String login, String firstName, String lastName, String email, String phone, Integer role) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }

    public boolean isEmpty(){
        if(this.login == null){
            return true;
        }
        else return false;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
