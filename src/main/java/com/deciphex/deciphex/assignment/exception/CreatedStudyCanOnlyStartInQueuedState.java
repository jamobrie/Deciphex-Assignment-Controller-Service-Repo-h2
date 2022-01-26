package com.deciphex.deciphex.assignment.exception;

public class CreatedStudyCanOnlyStartInQueuedState extends RuntimeException {
    public CreatedStudyCanOnlyStartInQueuedState(String studyStatus) {
        super("Study can only be created in QUEUED status. You have provided the value of: " + studyStatus);
    }
}
