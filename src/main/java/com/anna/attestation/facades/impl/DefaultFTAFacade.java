package com.anna.attestation.facades.impl;

import com.anna.attestation.entities.AuthInformation;
import com.anna.attestation.entities.User;
import com.anna.attestation.facades.FTAFacade;
import com.anna.attestation.repositories.AuthInformationRepository;
import com.anna.attestation.repositories.UserRepository;
import com.anna.attestation.services.impl.MailSender;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;


@Component
public class DefaultFTAFacade implements FTAFacade {

    @Autowired
    private MailSender mailSender;

    @Autowired
    private AuthInformationRepository authInformationRepo;

    @Autowired
    private UserRepository userRepository;

    //TODO:refactor
    @Override
    public Boolean sendCodeOnMail(AuthInformation authInformation) {

        authInformation.setCode(generateRandomCode());
        authInformationRepo.save(authInformation);

        mailSender.sendMessage(authInformation, templateSimpleMessage(authInformation.getCode()));
        return true;
    }

    //TODO:refactor
    @Override
    public Boolean sendLinkOnMail(AuthInformation authInformation) {
        mailSender.sendMessage(authInformation, templateForChangePassword(authInformation.getLogin()));
        return true;
    }

    //TODO:refactor
    @Override
    public Boolean sendCodeOnPhone(AuthInformation authInformation) {

        User user = userRepository.findUserByLogin(authInformation.getLogin());

        authInformation.setCode(generateRandomCode());
        authInformationRepo.save(authInformation);
        Message message = Message.creator(
                new PhoneNumber(user.getPhoneNumber()),
                new PhoneNumber("+18032237317"),
                templateSimpleMessage(authInformation.getCode()).getText())
                .create();
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
