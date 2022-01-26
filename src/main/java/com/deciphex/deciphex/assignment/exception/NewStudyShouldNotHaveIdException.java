package com.deciphex.deciphex.assignment.exception;


public class NewStudyShouldNotHaveIdException extends RuntimeException {

    public NewStudyShouldNotHaveIdException(Long id) {
        super("Study already exists for ID of: " + id);
    }

}
