package com.deciphex.deciphex.assignment.exception;

public class StudyNameCannotBeEmptyException extends RuntimeException {
    public StudyNameCannotBeEmptyException() {
        super("Study Name must not be null or empty");
    }
}
