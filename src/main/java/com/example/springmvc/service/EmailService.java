package com.example.springmvc.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {


    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {

        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(String username,
                          String toEmail,
                          String result) {


        SimpleMailMessage message = new SimpleMailMessage();

        message.setSubject("Love Calculator Prediction");
        message.setFrom("akintundegbenga30@gmail.com");
        message.setTo(toEmail);
        message.setText("Hi " + username + " the result predicted by Love Calculator App is " + result);
        javaMailSender.send(message);
    }


}
