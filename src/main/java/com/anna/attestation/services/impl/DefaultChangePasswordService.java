package com.anna.attestation.services.impl;

import com.anna.attestation.entities.AuthInformation;
import com.anna.attestation.entities.User;
import com.anna.attestation.repositories.AuthInformationRepository;
import com.anna.attestation.services.ChangePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultChangePasswordService implements ChangePasswordService {

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
    public Boolean changePassword(User user, String oldPassword, String newPassword, String repeatPassword) {
        AuthInformation authInformation = authInformationRepo.findAuthInformationByLogin(user.getLogin());

        if(authInformation.getPassword().equals(oldPassword) && newPassword.equals(repeatPassword)){
            authInformation.setPassword(newPassword);
            authInformationRepo.save(authInformation);
            return true;
        }
        else return false;
    }
}

