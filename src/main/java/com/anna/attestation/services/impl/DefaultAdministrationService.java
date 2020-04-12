package com.anna.attestation.services.impl;

import com.anna.attestation.entities.AuthInformation;
import com.anna.attestation.entities.User;
import com.anna.attestation.repositories.AuthInformationRepository;
import com.anna.attestation.repositories.UserRepository;
import com.anna.attestation.services.AdministartionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultAdministrationService implements AdministartionService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthInformationRepository authInformationRepository;

    //TODO:refactor
    @Override
    public Boolean addUser(String login, String firstName, String lastName, String email, String phone) {
        if (userRepository.findUserByLogin(login) == null){
            User user = new User();
            user.setLogin(login);
            user.setEmail(email);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPhoneNumber(phone);
            user.setRole(1);
            userRepository.save(user);
            AuthInformation authInformation = new AuthInformation();
            authInformation.setLogin(login);
            authInformation.setPassword(generateRandomPassword());
            authInformationRepository.save(authInformation);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Boolean deleteUser(String login) {
        User user = userRepository.findUserByLogin(login);
        if(user == null || user.getRole() == 2){
            return false;
        }
        else {
            userRepository.delete(user);
            authInformationRepository.delete(authInformationRepository.findAuthInformationByLogin(login));
            return true;
        }
    }


    private String generateRandomPassword(){
        String password = "123";

        return password;
    }
}
