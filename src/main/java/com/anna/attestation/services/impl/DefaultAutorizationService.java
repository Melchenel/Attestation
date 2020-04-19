package com.anna.attestation.services.impl;

import com.anna.attestation.entities.AuthInformation;
import com.anna.attestation.repositories.AuthInformationRepository;
import com.anna.attestation.repositories.UserRepository;
import com.anna.attestation.services.AutorizationService;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;


@Service
public class DefaultAutorizationService implements AutorizationService {

    @Autowired
    private AuthInformationRepository authInformation;

    @Override
    public Boolean signIn(String login, String password) {

        return Optional.ofNullable(authInformation.findAuthInformationByLogin(login))
                .map(auth -> auth.getPassword().equals(getMD5(password)))
                .orElse(false);
    }


    public String getMD5(String password) {
        String md5Hex = DigestUtils.md5Hex(password);

        return md5Hex;
    }

}
