package com.deciphex.deciphex.assignment.service;

import com.deciphex.deciphex.assignment.converter.ConversionHelper;
import com.deciphex.deciphex.assignment.entities.Study;
import com.deciphex.deciphex.assignment.repository.StudyRepository;
import com.deciphex.deciphex.assignment.validator.StudyValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudyService {

//    @Transactional
    private final StudyValidator studyValidator;
    private final StudyRepository studyRepository;
    private final ConversionHelper conversionHelper;

    public com.deciphex.deciphex.assignment.models.Study createStudy(com.deciphex.deciphex.assignment.models.Study newStudy) {

        studyValidator.validateStudy(newStudy);

        studyRepository.findAll();

        Study study = conversionHelper.convertStudyToEntity(newStudy);

        return conversionHelper.convertEntityToModel(studyRepository.save(study));
    }


}
