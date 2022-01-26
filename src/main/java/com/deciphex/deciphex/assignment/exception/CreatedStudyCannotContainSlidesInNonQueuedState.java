package com.deciphex.deciphex.assignment.exception;

import com.deciphex.deciphex.assignment.models.Slide;

public class CreatedStudyCannotContainSlidesInNonQueuedState extends RuntimeException {
    public CreatedStudyCannotContainSlidesInNonQueuedState(Slide slide) {
        super(String.format("The slides for this study you are creating must be in a queued state. However the slide of %s has a value of %s ",
                slide.getSlideName(),
                slide.getLifecycleStatus().toString()));
    }
}
