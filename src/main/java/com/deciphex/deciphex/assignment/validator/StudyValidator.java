package com.deciphex.deciphex.assignment.validator;

import com.deciphex.deciphex.assignment.exception.NewStudyShouldNotHaveIdException;
import com.deciphex.deciphex.assignment.exception.StudyNameCannotBeEmptyException;
import com.deciphex.deciphex.assignment.models.Slide;
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

        newStudy.setLifecycleStatus(QUEUED);

        newStudy.getSlideList().forEach(this::validateNewSlide);

//        if (!QUEUED.toString().equals(newStudy.getLifecycleStatus().toString())) {
//            throw new CreatedStudyCanOnlyStartInQueuedState(newStudy.getLifecycleStatus().toString());
//        }

    }

    private void validateNewSlide(Slide slide) {
        slide.setLifecycleStatus(QUEUED);
    }


}
