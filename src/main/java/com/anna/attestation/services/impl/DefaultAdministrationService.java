package com.anna.attestation.services.impl;

import com.anna.attestation.entities.AuthInformation;
import com.anna.attestation.entities.User;
import com.anna.attestation.exeptions.NoSuchUserException;
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
    public void addUser(String login, String firstName, String lastName, String email, String phone) {
        if (userRepository.findUserByLogin(login) == null) {
            userRepository.save(initUser(login,email,firstName,lastName,phone));

            AuthInformation authInformation = new AuthInformation();
            authInformation.setLogin(login);
            authInformation.setPassword(generateRandomPassword());

            authInformationRepository.save(authInformation);
        }
        else {
            throw new NoSuchUserException();
        }
    }

    @Override
    public void deleteUser(String login) {
        User user = userRepository.findUserByLogin(login);
        if (user == null || user.getRole() == 2) {
            throw new NoSuchUserException();
        }
        else {
            userRepository.delete(user);
            authInformationRepository.deleteByLogin(login);
        }
    }


    private String generateRandomPassword(){
        String password = "123";
        return password;
    }

    private User initUser(String login, String email, String firstName, String lastName, String phone){
        User user = new User();
        user.setLogin(login);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPhoneNumber(phone);
        user.setRole(1);

        return user;
    }
}
