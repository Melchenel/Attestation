package com.anna.attestation.services.impl;

import com.anna.attestation.repositories.UserRepository;
import com.anna.attestation.services.AutorizationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;


@Service
public class DefaultAutorizationService implements AutorizationService {

    Logger LOG = Logger.getLogger(DefaultAutorizationService.class.getName());

    @Autowired
    private UserRepository userRepository;

    @Override
    public Boolean signIn(String login, String password) {

        LOG.info(userRepository.findUserByLogin(login).toString());
        return null;
    }

    @Override
    public void signOut(String login) {

    }
}
