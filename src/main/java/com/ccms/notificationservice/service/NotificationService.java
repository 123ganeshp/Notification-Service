package com.ccms.notificationservice.service;

import com.ccms.notificationservice.model.Notification;

public interface NotificationService {
    void sendAccountCreationEmail(String recipientEmail, String accountName);
//Notification  sendAccountCreationEmail(Notification notification);
}
