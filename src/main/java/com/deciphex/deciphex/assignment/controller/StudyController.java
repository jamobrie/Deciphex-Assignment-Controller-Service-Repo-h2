package com.deciphex.deciphex.assignment.controller;

import com.deciphex.deciphex.assignment.StudyApplication;
import com.deciphex.deciphex.assignment.models.Slide;
import com.deciphex.deciphex.assignment.models.Study;
import com.deciphex.deciphex.assignment.models.StudyStatus;
import com.deciphex.deciphex.assignment.service.SlideService;
import com.deciphex.deciphex.assignment.service.StudyService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class StudyController {

    private static final Logger log = LoggerFactory.getLogger(StudyController.class);

    private final StudyService studyService;
    private final SlideService slideService;

    @PostMapping("/study")
    ResponseEntity<Study> createNewStudy(@RequestBody Study newStudy) {

        Study studyToBeCreated = studyService.createStudy(newStudy);

        return ResponseEntity.ok(studyToBeCreated);
    }

    @GetMapping("/study")
    ResponseEntity<Study> getStudy(@RequestBody Study newStudy) {

        Study studyToBeCreated = studyService.createStudy(newStudy);

        return ResponseEntity.ok(studyToBeCreated);
    }

    @GetMapping("/studyStatus")
    ResponseEntity<StudyStatus> getStudiesAndTheirStatus() {

        StudyStatus studyStatus = studyService.getAllStudies();

        return ResponseEntity.ok(studyStatus);
    }

    //API to update Slide data retroactively -> Must show as updated in each respective Study object
    @PutMapping("/slide")
    ResponseEntity<Slide> updateExistingSlideInfo(@RequestBody Slide slideToUpdate) {

        log.info("The slide to be updated is: " + slideToUpdate.toString());

        Slide studyToBeCreated = slideService.updateSlideInfo(slideToUpdate);

        log.info("The now updated slide is: " + studyToBeCreated.toString());

        return ResponseEntity.ok(studyToBeCreated);
    }

    @GetMapping("/slide")
    ResponseEntity<Slide> getExistingSlideByName(@RequestBody String slideName) {

        log.info("The slide to get has a name of: " + slideName);

        Slide studyToBeCreated = slideService.findSlide(slideName);

        log.info("The fetched slide is: " + studyToBeCreated.toString());

        return ResponseEntity.ok(studyToBeCreated);
    }


    //TODO Create a streamListener to read from: https://60b4ca624ecdc100174816d7.mockapi.io/api/v1/slide_metadata
    //It should consume these messages and be able to update the existing ones in DB

}
