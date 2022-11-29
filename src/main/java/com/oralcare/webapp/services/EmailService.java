package com.oralcare.webapp.services;

import com.oralcare.webapp.email.EmailDetails;
import com.oralcare.webapp.model.Order;

public interface EmailService {
    // Method
    // To send a simple email
    String sendSimpleMail(EmailDetails details);

    String replyMailContact(String email);

    String replyOrderMail(Order order,String name,String email);

    // Method
    // To send an email with attachment
    String sendMailWithAttachment(EmailDetails details);
}
