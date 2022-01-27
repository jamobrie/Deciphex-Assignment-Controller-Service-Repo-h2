package com.deciphex.deciphex.assignment.models;

import com.deciphex.deciphex.assignment.enums.LifecycleStatus;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class Study {

    private Long id;
    private String studyName;
    private String patientName;
    private String assessionId;
    private List<Slide> slideList;
    private LifecycleStatus lifecycleStatus;

}
