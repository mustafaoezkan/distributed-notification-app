package com.divideandsave.notifier.service;

import com.divideandsave.notifier.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @RabbitListener(queues = "${notification.queue}")
    public void receiveNotification(Notification notification) {
        System.out.println("Notification received: " + notification);
        // send to mobile device
    }
}
