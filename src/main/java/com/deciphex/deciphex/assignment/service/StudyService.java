package com.deciphex.deciphex.assignment.service;

import com.deciphex.deciphex.assignment.converter.ConversionHelper;
import com.deciphex.deciphex.assignment.entities.Study;
import com.deciphex.deciphex.assignment.models.StudyStatus;
import com.deciphex.deciphex.assignment.publisher.StudyPublisher;
import com.deciphex.deciphex.assignment.repository.StudyRepository;
import com.deciphex.deciphex.assignment.validator.StudyValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StudyService {

    //    @Transactional
    private final StudyValidator studyValidator;
    private final StudyRepository studyRepository;
    private final ConversionHelper conversionHelper;
    private final StudyPublisher studyPublisher;

    public com.deciphex.deciphex.assignment.models.Study createStudy(com.deciphex.deciphex.assignment.models.Study newStudy) {

        studyValidator.validateStudy(newStudy);

        studyPublisher.publishStudyToQueue(newStudy);

        Study study = conversionHelper.convertStudyModelToEntity(newStudy);

        return conversionHelper.convertStudyEntityToModel(studyRepository.save(study));
    }

    public StudyStatus getAllStudies() {
        List<Study> studyListEntity = studyRepository.findAll();

        List<com.deciphex.deciphex.assignment.models.Study> studyListModel = new ArrayList<>();

        studyListEntity.forEach(studyEntity -> {
            studyListModel.add(conversionHelper.convertStudyEntityToModel(studyEntity));
        });


        return new StudyStatus(studyListModel);
    }
}
