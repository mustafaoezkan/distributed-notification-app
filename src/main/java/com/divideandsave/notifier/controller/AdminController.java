package com.divideandsave.notifier.controller;

import com.divideandsave.notifier.entity.NotificationEntity;
import com.divideandsave.notifier.repository.NotificationRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin/notifications")
public class AdminController {

    private final NotificationRepository repository;

    public AdminController(NotificationRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<NotificationEntity> getAllNotifications() {
        return repository.findAll();
    }
}
