package com.anna.attestation.services;

public interface AdministartionService {
    public Boolean addUser(String login, String firstName, String lastName, String email, String phone);
    public Boolean deleteUser(String login);
}
