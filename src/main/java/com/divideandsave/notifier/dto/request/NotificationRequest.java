package com.divideandsave.notifier.dto.request;

import com.divideandsave.notifier.model.NotificationPriority;

public class NotificationRequest {

    private String title;

    private String message;

    private NotificationPriority priority;

    private String recipient;

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public NotificationPriority getPriority() {
        return priority;
    }

    public String getRecipient() {
        return recipient;
    }
}
