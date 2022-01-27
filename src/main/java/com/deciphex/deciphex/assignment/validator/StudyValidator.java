package com.deciphex.deciphex.assignment.validator;

import com.deciphex.deciphex.assignment.exception.NewStudyShouldNotHaveIdException;
import com.deciphex.deciphex.assignment.exception.StudyNameCannotBeEmptyException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static com.deciphex.deciphex.assignment.enums.LifecycleStatus.QUEUED;
import static org.apache.commons.lang3.StringUtils.isEmpty;

@Component
@AllArgsConstructor
public class StudyValidator {

    public void validateStudy(com.deciphex.deciphex.assignment.models.Study newStudy) {

        if (newStudy.getId() != null) {
            throw new NewStudyShouldNotHaveIdException(newStudy.getId());
        }

        if (isEmpty(newStudy.getStudyName())) {
            throw new StudyNameCannotBeEmptyException();
        }

        //TODO Re-evaluate this logic later
//        newStudy.getSlideList().forEach(slide -> {
//            if (!QUEUED.toString().equals(slide.getLifecycleStatus().toString())) {
//                throw new CreatedStudyCannotContainSlidesInNonQueuedState(slide);
//            }
//        });

        newStudy.setLifecycleStatus(QUEUED);

//        if (!QUEUED.toString().equals(newStudy.getLifecycleStatus().toString())) {
//            throw new CreatedStudyCanOnlyStartInQueuedState(newStudy.getLifecycleStatus().toString());
//        }

    }


}
