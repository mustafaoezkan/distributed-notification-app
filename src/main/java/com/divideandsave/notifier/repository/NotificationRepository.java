package com.divideandsave.notifier.repository;

import com.divideandsave.notifier.entity.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {
}