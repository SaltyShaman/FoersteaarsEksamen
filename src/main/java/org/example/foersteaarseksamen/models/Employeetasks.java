package org.example.foersteaarseksamen.models;

public class Employeetasks {

    private int employeeId; //foreign and primary key
    private Integer taskId; //foreign and primary key

    public Employeetasks() {
    }
    public Employeetasks(int employeeId, Integer taskId) {
        this.employeeId = employeeId;
        this.taskId = taskId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }
}
