package com.deciphex.deciphex.assignment.models;

import com.deciphex.deciphex.assignment.enums.LifecycleStatus;
import lombok.Data;

@Data
public class Slide {

    //Note:
    //1. Each Slide is processed in parallel ---> Potential multi-threading
    //2. When the application is restarted, the job is resumed from where it left off (PROCESSING slides are re QUEUED):
    // ----> so a listener will have to pick up any Study(s) in a queued and processing state

    // ---->  A dead letter queue will be needed for any Study(s) that are published to the queue while the Application is:
    //(A) Down
    //(B) Restarting

    private long id;
    private String slideName;

    //Volatile data, subject to change
    private String organ;
    private String section;
    private String block;
    private LifecycleStatus lifecycleStatus;

    @Override
    public String toString() {
        return "Slide{" +
                "id=" + id +
                ", slideName='" + slideName + '\'' +
                ", organ='" + organ + '\'' +
                ", section='" + section + '\'' +
                ", block='" + block + '\'' +
                ", lifecycleStatus=" + lifecycleStatus +
                '}';
    }
}
