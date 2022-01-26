package com.deciphex.deciphex.assignment.validator;

import com.deciphex.deciphex.assignment.entities.Study;
import com.deciphex.deciphex.assignment.exception.CreatedStudyCanOnlyStartInQueuedState;
import com.deciphex.deciphex.assignment.exception.CreatedStudyCannotContainSlidesInNonQueuedState;
import com.deciphex.deciphex.assignment.exception.NewStudyShouldNotHaveIdException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static com.deciphex.deciphex.assignment.enums.LifecycleStatus.QUEUED;

@Component
@AllArgsConstructor
public class StudyValidator {

    public void validateStudy(com.deciphex.deciphex.assignment.models.Study newStudy) {

//        if (newStudy.getId() != null) {
//            throw new NewStudyShouldNotHaveIdException(newStudy.getId());
//        }
//
//        newStudy.getSlideList().forEach(slide -> {
//            if (!QUEUED.toString().equals(slide.getLifecycleStatus().toString())) {
//            throw new CreatedStudyCannotContainSlidesInNonQueuedState(slide);
//            }
//        });

        if (!QUEUED.toString().equals(newStudy.getLifecycleStatus().toString())) {
            throw new CreatedStudyCanOnlyStartInQueuedState(newStudy.getLifecycleStatus().toString());
        }

    }


}
