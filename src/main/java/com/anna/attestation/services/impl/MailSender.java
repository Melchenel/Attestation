package com.anna.attestation.services.impl;

import com.anna.attestation.entities.AuthInformation;
import com.anna.attestation.repositories.AuthInformationRepository;
import com.anna.attestation.repositories.UserRepository;
import com.anna.attestation.services.FTAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSender implements FTAService{

    @Value("${spring.mail.username}")
    private String username;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private AuthInformationRepository authInformationRepo;

    @Autowired
    private UserRepository userRepo;
    @Override
    public Boolean sendMessage(AuthInformation authInformation) {
        writeAndSendMessage(getUserEmail(authInformation.getLogin()), templateSimpleMessage(authInformation.getCode()));
        return true;
    }

    public void writeAndSendMessage(String email, SimpleMailMessage message) {
        message.setFrom(username);
        message.setTo(email);
        message.setSubject("Autorization code");
        mailSender.send(message);
        System.out.println("OK");

    }

    public SimpleMailMessage templateSimpleMessage(String code) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText(
                "Не сообщайте этот код никому: "+ code +"\n");
        return message;
    }

    public SimpleMailMessage templateForChangePassword(String code){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText(
                "Не сообщайте этот код никому: "+ code +"\n");
        return message;
    }

    private String getUserEmail(String login){
        return userRepo.findUserByLogin(login).getEmail();
    }
}
