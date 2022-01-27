package com.deciphex.deciphex.assignment.exception;

public class InvalidSlideNameException extends RuntimeException {

    public InvalidSlideNameException() {
        super("Slide name must not be blank or empty");
    }

}
