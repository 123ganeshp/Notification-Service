package com.ccms.notificationservice.service.impl;

import com.ccms.notificationservice.model.Notification;
import com.ccms.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendAccountCreationEmail(String recipientEmail, String accountName) {
        // Generate a random account number
        String cardNumber = generateCardNumber();

        // Email content
        String subject = "ACCOUNT CREATED";
        String content = String.format("Congratulations %s! Your account has been successfully created.\n\n" +
                "Your account details:\nAccount Name: %s\nYour card number: %s", accountName, accountName, cardNumber);

        // Create email message
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject(subject);
        message.setText(content);

        // Send email
        mailSender.send(message);

        // Optionally, save notification status in the database
    }

    private String generateCardNumber() {
        // Generate a random 16-digit card number
        // return UUID.randomUUID().toString().replace("-", "").substring(0, 16);
        Random random = new Random();
        StringBuilder cardNumber = new StringBuilder();

        for (int i = 0; i < 16; i++) {
            int digit = random.nextInt(10);  // Generates a random number between 0 and 9
            cardNumber.append(digit);
        }

        return cardNumber.toString();
    }


}
