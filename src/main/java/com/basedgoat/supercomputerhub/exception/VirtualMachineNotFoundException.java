package com.basedgoat.supercomputerhub.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class VirtualMachineNotFoundException extends NotFoundException {
    public VirtualMachineNotFoundException() {
        super();
        setMessage("Virtual Machine not found");
    }

    public VirtualMachineNotFoundException(String message) {
        setMessage(message);
    }
}
