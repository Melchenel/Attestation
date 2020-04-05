package com.anna.attestation.facades;

public interface AutorizationFacade {

    Boolean signIn(String login, String password);

    void signOut(String login);

}
