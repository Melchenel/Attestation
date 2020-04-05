package com.anna.attestation.facades.impl;

import com.anna.attestation.facades.FTAFacade;
import com.anna.attestation.repositories.UserRepository;
import com.anna.attestation.services.impl.DefaultFTAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DefaultFTAFacade implements FTAFacade {

    private String code;

    @Autowired
    private DefaultFTAService defaultFTAService;

    @Autowired
    private UserRepository user;

    @Override
    public Boolean sendCodeOnMail(String login) {
        generateRandomCode();
        defaultFTAService.sendMessage(code, user.findUserByLogin(login).getEmail());
        return true;
    }

    @Override
    public void generateRandomCode() {
        this.code = UUID.randomUUID().toString();//String.valueOf(1000 + (int)(Math.random() * ((9999 - 1000) + 1)));
    }

    @Override
    public String getCode() {
        return code;
    }

}
