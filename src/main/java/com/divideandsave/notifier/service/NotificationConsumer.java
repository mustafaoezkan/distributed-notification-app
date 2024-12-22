package com.divideandsave.notifier.service;

import com.divideandsave.notifier.model.Notification;
import com.divideandsave.notifier.model.NotificationPriority;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @RabbitListener(queues = "${notification.queue}")
    public void receiveNotification(Notification notification) {
        System.out.println("Notification received: " + notification);
        // send to mobile device
    }

    @RabbitListener(queues = "${notification.queue}")
    public void processNotification(Notification notification) {
        if (notification.getPriority() == NotificationPriority.HIGH) {
            System.out.println("Processing HIGH priority notification: " + notification);
        } else {
            System.out.println("Processing notification: " + notification);
        }
    }
}
