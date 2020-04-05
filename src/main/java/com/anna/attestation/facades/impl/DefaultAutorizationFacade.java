package com.anna.attestation.facades.impl;

import com.anna.attestation.facades.AutorizationFacade;
import com.anna.attestation.services.AutorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultAutorizationFacade implements AutorizationFacade {

    @Autowired
    private AutorizationService autorizationService;

    @Override
    public Boolean signIn(String login, String password) {
        return autorizationService.signIn(login,password);
    }

    @Override
    public void signOut(String login) {

    }
}
