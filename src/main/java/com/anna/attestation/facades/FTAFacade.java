package com.anna.attestation.facades;

public interface FTAFacade {

    Boolean sendCodeOnMail(String login);

    Boolean sendCodeOnPhone(String login);
}
