package com.divideandsave.notifier.service;

import com.divideandsave.notifier.entity.NotificationEntity;
import com.divideandsave.notifier.model.Notification;
import com.divideandsave.notifier.repository.NotificationRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    private final NotificationRepository repository;

    public NotificationConsumer(NotificationRepository repository) {
        this.repository = repository;
    }

    // There is a round-robin algorithm so the listeners works sequentially
    @RabbitListener(queues = "${notification.queue}")
    public void receiveNotification(Notification notification) {
        System.out.println("Notification received: " + notification);
        // send to mobile device
    }

    @RabbitListener(queues = "${notification.queue}")
    public void processNotification(Notification notification) {
        NotificationEntity entity = new NotificationEntity();
        entity.setMessage(notification.getMessage());
        entity.setRecipient(notification.getRecipient());
        entity.setPriority(notification.getPriority().toString());
        entity.setStatus("SENT");
        repository.save(entity);

        System.out.println("Notification processed and logged: " + entity);
    }
}
