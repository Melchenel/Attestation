package com.anna.attestation.facades;

public interface FTAFacade {

    Boolean sendCodeOnMail(String login);

    void generateRandomCode();

    String getCode();

}
