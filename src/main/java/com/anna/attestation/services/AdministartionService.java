package com.anna.attestation.services;

public interface AdministartionService {
    public void addUser(String login, String firstName, String lastName, String email, String phone);
    public void deleteUser(String login);
}
