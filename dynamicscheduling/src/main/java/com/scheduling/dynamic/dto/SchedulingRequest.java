package com.scheduling.dynamic.dto;


public class SchedulingRequest {
    private String taskName;
    private String cronExpression;
    private boolean isactive;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public boolean isIsactive() {
        return isactive;
    }
    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

}
