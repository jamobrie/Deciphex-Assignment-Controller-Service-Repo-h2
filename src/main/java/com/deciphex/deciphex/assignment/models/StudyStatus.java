package com.deciphex.deciphex.assignment.models;

import com.deciphex.deciphex.assignment.enums.LifecycleStatus;

import java.util.HashMap;
import java.util.List;

public class StudyStatus {

    private final int totalStudies;
    private final HashMap<LifecycleStatus, Double> statusPercentages;

    public StudyStatus(List<Study> studyListModel) {
        this.totalStudies = studyListModel.size();
        this.statusPercentages = calculatePercentage(studyListModel);
    }

    private HashMap<LifecycleStatus, Double> calculatePercentage(List<Study> studyListModel) {
        HashMap<LifecycleStatus, Double> percentageMap = new HashMap<>();

        long queuedCount = studyListModel.stream().map(Study::getLifecycleStatus).filter(status ->
                status.equals(LifecycleStatus.QUEUED)).count();

        long processedCount = studyListModel.stream().map(Study::getLifecycleStatus).filter(status ->
                status.equals(LifecycleStatus.PROCESSING)).count();

        long completedCount = studyListModel.stream().map(Study::getLifecycleStatus).filter(status ->
                status.equals(LifecycleStatus.COMPLETED)).count();

        percentageMap.put(LifecycleStatus.QUEUED, Double.valueOf(((totalStudies / queuedCount) * 100)));
        percentageMap.put(LifecycleStatus.PROCESSING, Double.valueOf(((totalStudies / processedCount) * 100)));
        percentageMap.put(LifecycleStatus.COMPLETED, Double.valueOf(((totalStudies / completedCount) * 100)));

        return statusPercentages;
    }


}
