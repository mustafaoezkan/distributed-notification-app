package com.divideandsave.notifier.controller;

import com.divideandsave.notifier.service.NotificationProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationProducer notificationProducer;

    public NotificationController(NotificationProducer notificationProducer) {
        this.notificationProducer = notificationProducer;
    }

    @PostMapping
    public String sendNotification(@RequestParam String title, @RequestParam String message) {
        notificationProducer.sendNotification(title, message);
        return "Notification sent!";
    }
}
