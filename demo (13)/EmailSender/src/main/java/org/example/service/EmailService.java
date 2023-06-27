package org.example.service;

import org.example.model.Email;
import org.example.service.utils.EmailCSVReader;
import org.example.service.utils.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

@Component
public class EmailService {
    private final EmailCSVReader emailCSVReader;
    private final EmailSender emailSender;

    @Autowired
    public EmailService(EmailCSVReader emailCSVReader, EmailSender emailSender) {
        this.emailCSVReader = emailCSVReader;
        this.emailSender = emailSender;
    }

    public void sendBulkEmails(Email email) {
        try {
            List<String> emailAddresses = emailCSVReader.getEmails();

            for (String emailAddress : emailAddresses) {
                System.out.println("Sending email to: " + emailAddress);
                emailSender.sendMessage(emailAddress,email.getSubject(), email.getContent());
            }
        } catch (IOException e) {
            // Handle IOException
            System.err.println("An error occurred while reading email addresses: " + e.getMessage());
        } catch (MessagingException e) {
            // Handle MessagingException
            System.err.println("An error occurred while sending emails: " + e.getMessage());
        }
    }
}

