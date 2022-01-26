package com.deciphex.deciphex.assignment.controller;

import com.deciphex.deciphex.assignment.models.Study;
import com.deciphex.deciphex.assignment.service.StudyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class StudyController {

    private final StudyService studyService;


    @PostMapping("/study")
    ResponseEntity<Study> createNewStudy(@RequestBody Study newStudy) {

        Study studyToBeCreated = studyService.createStudy(newStudy);

        return ResponseEntity.ok(studyToBeCreated);
    }

}
