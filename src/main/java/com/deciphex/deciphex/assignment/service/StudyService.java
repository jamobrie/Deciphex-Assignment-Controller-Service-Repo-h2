package com.deciphex.deciphex.assignment.service;

import com.deciphex.deciphex.assignment.converter.ConversionHelper;
import com.deciphex.deciphex.assignment.entities.Study;
import com.deciphex.deciphex.assignment.entities.User;
import com.deciphex.deciphex.assignment.entities.UserRole;
import com.deciphex.deciphex.assignment.models.StudyStatus;
import com.deciphex.deciphex.assignment.repository.StudyRepository;
import com.deciphex.deciphex.assignment.repository.UserRepo;
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
    private final UserRepo userRepo;

    public com.deciphex.deciphex.assignment.models.Study createStudy(com.deciphex.deciphex.assignment.models.Study newStudy) {

        studyValidator.validateStudy(newStudy);


//        Study study1 = new Study();
//        study1.setLifecycleStatus("QUEUED");
//
//
//        studyRepository.save(study1);
//

        UserRole userRole = new UserRole();
        userRole.setRoleId(22L);

        List<User> userList = new ArrayList<>();
        User user = new User();
        user.setUserRole(userRole);
        User user2 = new User();
        user2.setUserRole(userRole);

        userList.add(user);
        userList.add(user2);

//        userRepo.save(userRole);

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
