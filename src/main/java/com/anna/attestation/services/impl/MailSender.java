package com.anna.attestation.services.impl;

import com.anna.attestation.entities.AuthInformation;
import com.anna.attestation.entities.User;
import com.anna.attestation.repositories.AuthInformationRepository;
import com.anna.attestation.repositories.UserRepository;
import com.anna.attestation.services.MailService;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSender implements MailService {

    @Value("${spring.mail.username}")
    private String username;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private AuthInformationRepository authInformationRepo;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Boolean sendCodeOnMail(AuthInformation authInformation) {

        authInformation.setCode(generateRandomCode());
        authInformationRepo.save(authInformation);
        sendMessage(authInformation, templateSimpleMessage(authInformation.getCode()));

        return true;
    }

    @Override
    public Boolean sendLinkOnMail(String login) {
        AuthInformation authInformation = authInformationRepo.findAuthInformationByLogin(login);
        sendMessage(authInformation, templateForChangePassword(authInformation.getLogin()));
        return true;
    }

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


    public Boolean sendMessage(AuthInformation authInformation, SimpleMailMessage message) {
        generateMessage(getUserEmail(authInformation.getLogin()), message);
        return true;
    }

    public void generateMessage(String email, SimpleMailMessage message) {
        message.setFrom(username);
        message.setTo(email);
        message.setSubject("Autorization code");
        mailSender.send(message);
        System.out.println("OK");

    }


    private String getUserEmail(String login){
        return userRepo.findUserByLogin(login).getEmail();
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
