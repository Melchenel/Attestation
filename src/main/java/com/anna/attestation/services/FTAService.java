package com.anna.attestation.services;

import com.anna.attestation.entities.AuthInformation;

public interface FTAService {
    Boolean sendMessage(AuthInformation authInformation);
}
