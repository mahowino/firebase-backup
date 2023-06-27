package org.example.service.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Component
public class EmailSender {


    private final Session emailSession;

    @Autowired
    public EmailSender(Session emailSession) {
        this.emailSession = emailSession;
    }

    public void sendMessage(String recipient, String subject, String content) throws MessagingException {
        Message message = createMessage(recipient,subject, content);
        Transport.send(message);
        System.out.println("Email has been sent");
    }

    private Message createMessage(String recipient,String subject, String content) throws MessagingException {
        Message message = new MimeMessage(emailSession);
        message.setFrom(new InternetAddress(emailSession.getProperty("mail.smtp.user")));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
        message.setSubject(subject);
        message.setContent(content, "text/html; charset=utf-8");

        return message;
    }


}
