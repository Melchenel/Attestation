package com.anna.attestation.facades.impl;

import com.anna.attestation.entities.AuthInformation;
import com.anna.attestation.facades.ChangePasswordFacade;
import com.anna.attestation.repositories.AuthInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultChangePasswordFacade implements ChangePasswordFacade {

    @Autowired
    AuthInformationRepository authInformationRepo;

    @Override
    public void resetPassword(String login) {
        AuthInformation authInformation = authInformationRepo.findAuthInformationByLogin(login);
        authInformation.setPassword("");
        authInformationRepo.save(authInformation);
    }

    @Override
    public Boolean restorePassword(String login, String newPassword, String repeatPassword) {
        AuthInformation authInformation = authInformationRepo.findAuthInformationByLogin(login);
        if(newPassword.equals(repeatPassword)){
            authInformation.setPassword(newPassword);
            authInformationRepo.save(authInformation);
            return true;
        }
        return false;
    }



    @Override
    public Boolean changePassword(String login, String newPassword, String repeatPassword) {
        return null;
    }
}
