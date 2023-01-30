package com.example.moviedb.services.ServiceIMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceIMPL {
    @Autowired
    private JavaMailSender javaMailSender;

    public void mailSender(String toMail, String subject, String body){
        SimpleMailMessage Newmail = new SimpleMailMessage();
        Newmail.setTo(toMail);
        Newmail.setSubject(subject);
        Newmail.setText(body);
        javaMailSender.send(Newmail);
        System.out.println("message send");
    }
}
