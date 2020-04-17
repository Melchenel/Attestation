package com.anna.attestation.services;

import com.anna.attestation.entities.AuthInformation;
import org.springframework.mail.SimpleMailMessage;

public interface MailService {
    Boolean sendCodeOnMail(AuthInformation authInformation);

    Boolean sendLinkOnMail(String login);

    Boolean sendCodeOnPhone(AuthInformation authInformation);
}
