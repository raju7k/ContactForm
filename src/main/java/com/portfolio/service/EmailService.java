package com.portfolio.service;

import com.portfolio.model.ContactRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(ContactRequest request) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo("rajukarri.1070@gmail.com");

        message.setSubject("New Portfolio Contact Message");

        message.setText(
                "First Name: " + request.getFirstName() + "\n" +
                "Last Name: " + request.getLastName() + "\n" +
                "Email: " + request.getEmail() + "\n\n" +
                "Message:\n" + request.getMessage()
        );

        mailSender.send(message);
    }
}