package com.portfolio.controller;

import com.portfolio.model.ContactRequest;
import com.portfolio.service.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class ContactController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-email")
    public String sendEmail(@RequestBody ContactRequest request) {

        try {

            emailService.sendEmail(request);

            return "Message Sent Successfully!";

        } catch (Exception e) {

            e.printStackTrace();

            return "ERROR : " + e.getMessage();
        }
    }
}