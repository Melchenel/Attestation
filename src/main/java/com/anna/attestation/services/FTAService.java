package com.anna.attestation.services;

import com.anna.attestation.entities.AuthInformation;
import org.springframework.mail.SimpleMailMessage;

public interface FTAService {
    Boolean sendMessage(AuthInformation authInformation, SimpleMailMessage message);
}
