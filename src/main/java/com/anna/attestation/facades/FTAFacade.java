package com.anna.attestation.facades;

import com.anna.attestation.entities.AuthInformation;

public interface FTAFacade {

    Boolean sendCodeOnMail(AuthInformation authInformation);

    Boolean sendLinkOnMail(AuthInformation authInformation);

    Boolean sendCodeOnPhone(AuthInformation authInformation);
}
