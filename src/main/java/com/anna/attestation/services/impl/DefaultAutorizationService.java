package com.anna.attestation.services.impl;

import com.anna.attestation.services.AutorizationService;
import org.springframework.stereotype.Service;

@Service
public class DefaultAutorizationService implements AutorizationService {
    @Override
    public Boolean signIn(String login, String password) {
        return null;
    }

    @Override
    public void signOut(String login) {

    }
}
