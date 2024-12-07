package org.example.foersteaarseksamen.models;

public class Task {
    private int taskId; // Primary key
    private String taskName;
    private int estimatedWorkHoursPerTask;

    // Constructor
    public Task(int taskId, String taskName, int estimatedWorkHoursPerTask) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.estimatedWorkHoursPerTask = estimatedWorkHoursPerTask;
    }

    // No-argument constructor
    public Task() {
    }

    // Getters and setters
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getEstimatedWorkHoursPerTask() {
        return estimatedWorkHoursPerTask;
    }

    public void setEstimatedWorkHoursPerTask(int estimatedWorkHoursPerTask) {
        this.estimatedWorkHoursPerTask = estimatedWorkHoursPerTask;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", estimatedWorkHoursPerTask=" + estimatedWorkHoursPerTask +
                '}';
    }
}
