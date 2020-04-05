package com.anna.attestation.facades.impl;

import com.anna.attestation.facades.FTAFacade;
import com.anna.attestation.repositories.UserRepository;
import com.anna.attestation.services.impl.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DefaultFTAFacade implements FTAFacade {

    private String code;

    @Autowired
    private MailSender mailSender;

    @Autowired
    private UserRepository user;

    @Override
    public Boolean sendCodeOnMail(String login) {
        generateRandomCode();
        mailSender.sendMessage(code, user.findUserByLogin(login).getEmail());
        return true;
    }

    @Override
    public void generateRandomCode() {
        this.code = String.valueOf(1000 + (int)(Math.random() * ((9999 - 1000) + 1)));
    }

    @Override
    public String getCode() {
        return code;
    }

}
