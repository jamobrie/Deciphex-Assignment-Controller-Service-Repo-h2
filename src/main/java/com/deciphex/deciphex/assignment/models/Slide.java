package com.deciphex.deciphex.assignment.models;

import lombok.Data;

@Data
public class Slide {

    //Note:
    //1. Each Slide is processed in parallel
    //2. When the application is restarted, the job is resumed from where it left off (PROCESSING slides are re QUEUED):
    // ----> so a listener will have to pick up any Study(s) in a queued and processing state

    // ---->  A dead letter queue will be needed for any Study(s) that are published to the queue while the Application is:
    //(A) Down
    //(B) Restarting

    //TODO -> Add ID
    private String slideName;

    //TODO Is this the external metadata?
    private String organ;
    private String section;
    private String block;

}