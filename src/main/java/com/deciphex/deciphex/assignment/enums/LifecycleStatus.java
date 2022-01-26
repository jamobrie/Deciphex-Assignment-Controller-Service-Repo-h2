package com.deciphex.deciphex.assignment.enums;

public enum LifecycleStatus {

    COMPLETED("COMPLETED"), // when all Slide(s) in a Study are COMPLETED
    PROCESSING("PROCESSING"), //when some of its Slide(s) in a Study are PROCESSING
    QUEUED("QUEUED"); //when all its Slide(s) in a Study are QUEUED

    private final String value;

    LifecycleStatus(final String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
