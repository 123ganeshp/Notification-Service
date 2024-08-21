package com.ccms.notificationservice.controller;

import com.ccms.notificationservice.model.Notification;
import com.ccms.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/send")
    public ResponseEntity<String> sendAccountCreationNotification(@RequestBody Notification request) {
          notificationService.sendAccountCreationEmail(request.getRecipientEmail(), request.getAccountName());
        return new ResponseEntity<>("Notification sent successfully", HttpStatus.OK);
    }
}
