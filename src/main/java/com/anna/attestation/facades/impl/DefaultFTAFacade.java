package com.anna.attestation.facades.impl;

import com.anna.attestation.entities.AuthInformation;
import com.anna.attestation.facades.FTAFacade;
import com.anna.attestation.repositories.AuthInformationRepository;
import com.anna.attestation.repositories.UserRepository;
import com.anna.attestation.services.impl.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;


@Component
public class DefaultFTAFacade implements FTAFacade {

    @Autowired
    private MailSender mailSender;

    @Autowired
    private AuthInformationRepository authInformationRepo;

    //TODO:refactor
    @Override
    public Boolean sendCodeOnMail(String login) {
        AuthInformation authInformation = authInformationRepo.findAuthInformationByLogin(login);
        authInformation.setCode(generateRandomCode());
        authInformationRepo.save(authInformation);
        mailSender.sendMessage(authInformation, templateSimpleMessage(authInformation.getCode()));
        return true;
    }

    //TODO:refactor
    @Override
    public Boolean sendLinkOnMail(String login) {
        AuthInformation authInformation = authInformationRepo.findAuthInformationByLogin(login);
        mailSender.sendMessage(authInformation, templateForChangePassword(login));
        return true;
    }


    private String generateRandomCode() {
        return String.valueOf(1000 + (int)(Math.random() * ((9999 - 1000) + 1)));
    }

    private SimpleMailMessage templateSimpleMessage(String code) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText(
                "Не сообщайте этот код никому: "+ code +"\n");
        return message;
    }
    //TODO:генерация рандомной ссылки
    private SimpleMailMessage templateForChangePassword(String login){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText(
                "Для сброса пароля перейдите по следующей ссылке http://localhost:8080/restorePassword/" + login + "\n");
        return message;
    }

}
