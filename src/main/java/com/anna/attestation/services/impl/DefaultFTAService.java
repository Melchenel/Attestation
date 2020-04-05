package com.anna.attestation.services.impl;

import com.anna.attestation.services.FTAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class DefaultFTAService implements FTAService{

    @Autowired
    public JavaMailSender emailSender;

    @Override
    public Boolean sendMessage(String code, String email) {
        sendSimpleMessage(email, templateSimpleMessage(code));
        return true;
    }

    public void sendSimpleMessage(String to, SimpleMailMessage message) {
        message.setTo(to);
        emailSender.send(message);

    }

    public SimpleMailMessage templateSimpleMessage(String code) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText(
                "Не сообщайте этот код никому: "+ code +"\n");
        return message;
    }
}
