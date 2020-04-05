package com.anna.attestation.facades.impl;

import com.anna.attestation.entities.AuthInformation;
import com.anna.attestation.facades.FTAFacade;
import com.anna.attestation.repositories.AuthInformationRepository;
import com.anna.attestation.repositories.UserRepository;
import com.anna.attestation.services.impl.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DefaultFTAFacade implements FTAFacade {

    @Autowired
    private MailSender mailSender;

    @Autowired
    private AuthInformationRepository authInformationRepo;

    @Override
    public Boolean sendCodeOnMail(String login) {
        AuthInformation authInformation = authInformationRepo.findAuthInformationByLogin(login);
        authInformation.setCode(generateRandomCode());
        authInformationRepo.save(authInformation);
        mailSender.sendMessage(authInformation);
        return true;
    }

    @Override
    public Boolean sendCodeOnPhone(String login) {
        return null;
    }

    @Override
    public String generateRandomCode() {
        return String.valueOf(1000 + (int)(Math.random() * ((9999 - 1000) + 1)));
    }


}
