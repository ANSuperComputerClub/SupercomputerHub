package com.basedgoat.supercomputerhub.exception;

public class NotFoundException extends Throwable {
    private String message;

    public NotFoundException() {
        super();
        message = "Object not found";
    }

    public NotFoundException(String message) {
        this.message = message;
    }

    protected void setMessage(String message) {
        this.message = message;
    }

    public String toString() {
        return message;
    }
}
