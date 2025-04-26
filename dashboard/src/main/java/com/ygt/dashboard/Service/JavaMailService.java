package com.ygt.dashboard.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ygt.dashboard.Model.Support;

@Service
public class JavaMailService {
    

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendSupportEmail(Support message){
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo("kaanhascann@gmail.com"); 
        email.setSubject("Yeni Destek Mesajı: " + message.getSubject());
        email.setText("Gönderen: " + message.getName() + "\n"
                    + "Email: " + message.getEmail() + "\n\n"
                    + "Mesaj:\n" + message.getMessage());

        javaMailSender.send(email);
    }
}
