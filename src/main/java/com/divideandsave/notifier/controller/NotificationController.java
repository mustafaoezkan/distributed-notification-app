package com.divideandsave.notifier.controller;

import com.divideandsave.notifier.dto.request.NotificationRequest;
import com.divideandsave.notifier.service.NotificationProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationProducer notificationProducer;

    public NotificationController(NotificationProducer notificationProducer) {
        this.notificationProducer = notificationProducer;
    }

    @PostMapping
    public String sendNotification(@RequestBody NotificationRequest request) {
        notificationProducer.sendNotification(request);
        return "Notification sent!";
    }
}
