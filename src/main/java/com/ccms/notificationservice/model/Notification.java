package com.ccms.notificationservice.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
 @Table(name = "notifications")
@Data
public class Notification {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cardNumber;

    private String accountName;

    private String recipientEmail;

//     @Column(name = "recipient_email")
//    private String recipientEmail;
//
//     @Column(name = "subject")
//    private String subject;
//
//     @Column(name = "content", length = 5000)
//    private String content;
//
//     @Column(name = "status")
//    private String status; // e.g., "SENT", "PENDING"
}

