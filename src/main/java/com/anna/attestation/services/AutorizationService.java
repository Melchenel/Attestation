package com.anna.attestation.services;

public interface AutorizationService {
    Boolean signIn(String login, String password);
    void signOut(String login);
}
