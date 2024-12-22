package com.divideandsave.notifier.model;

public class Notification {

    private String id;
    private String title;
    private String message;
    private NotificationPriority priority;

    public Notification() {}

    public Notification(String id, String title, String message, NotificationPriority priority) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NotificationPriority getPriority() {
        return priority;
    }

    public void setPriority(NotificationPriority priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", priority=" + priority +
                '}';
    }
}
