package com.deciphex.deciphex.assignment.exception;

public class SlideDoesNotExistForThatNameException extends RuntimeException {


    public SlideDoesNotExistForThatNameException(String slideName) {
        super("Slide does not exist for slide name of: " + slideName);
    }
}
