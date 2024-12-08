package org.example.foersteaarseksamen.models;

public class Task {
    private Integer taskId; // Primary key
    private String taskName;
    private Integer estimatedWorkHoursPerTask;

    public Task() {
    }

    public Task(Integer taskId, String taskName, Integer estimatedWorkHoursPerTask) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.estimatedWorkHoursPerTask = estimatedWorkHoursPerTask;
    }



    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getEstimatedWorkHoursPerTask() {
        return estimatedWorkHoursPerTask;
    }

    public void setEstimatedWorkHoursPerTask(Integer estimatedWorkHoursPerTask) {
        this.estimatedWorkHoursPerTask = estimatedWorkHoursPerTask;
    }



}
