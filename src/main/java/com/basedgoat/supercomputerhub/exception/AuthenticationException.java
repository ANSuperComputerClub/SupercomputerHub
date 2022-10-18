package com.basedgoat.supercomputerhub.exception;

public class AuthenticationException extends Throwable {
    public AuthenticationException() {
        super();
    }

    public String toString() {
        return "Authentication failed";
    }
}
