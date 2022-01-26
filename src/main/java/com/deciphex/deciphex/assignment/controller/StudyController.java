package com.deciphex.deciphex.assignment.controller;

import com.deciphex.deciphex.assignment.service.StudyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class StudyController {

    private final StudyService studyService;

}
