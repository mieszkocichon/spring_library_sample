package com.mieszkocichon.main.exception;

public class ErrorMessage {
    private final String status;
    private final String message;
    private final String description;

    public ErrorMessage(String status, String message, String description) {
        this.status = status;
        this.message = message;
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }
}
