package com.basedgoat.supercomputerhub.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException() {
        super();
        setMessage("User not found");
    }
    public UserNotFoundException(String message) { setMessage(message); }
}
