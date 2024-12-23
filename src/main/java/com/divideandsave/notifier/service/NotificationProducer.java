package com.divideandsave.notifier.service;

import com.divideandsave.notifier.dto.request.NotificationRequest;
import com.divideandsave.notifier.model.Notification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NotificationProducer {

    private final RabbitTemplate rabbitTemplate;

    @Value("${notification.exchange}")
    private String exchange;

    @Value("${notification.routing-key}")
    private String routingKey;

    public NotificationProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendNotification(NotificationRequest request) {
        Notification notification = new Notification(UUID.randomUUID().toString(), request.getTitle(), request.getMessage(), request.getPriority(), request.getRecipient());
        rabbitTemplate.convertAndSend(exchange, routingKey, notification);
        System.out.println("Notification sent: " + notification);
    }
}
