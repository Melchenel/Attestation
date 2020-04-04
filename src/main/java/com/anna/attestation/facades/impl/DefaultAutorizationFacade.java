package com.anna.attestation.facades.impl;

import com.anna.attestation.facades.AutorizationFacade;
import org.springframework.stereotype.Component;

@Component
public class DefaultAutorizationFacade implements AutorizationFacade {
    @Override
    public Boolean signIn(String login, String password) {
        return true;
    }

    @Override
    public void signOut(String login) {

    }
}
