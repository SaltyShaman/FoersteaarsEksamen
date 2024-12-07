package org.example.foersteaarseksamen.models;

import java.util.List;

public class Employee {

    private int employeeId;
    private String employeeName;
    private Integer calculatorTableId;
    private List<Task> tasks;  // List<Task> to store multiple tasks

    public Employee() {
    }

    public Employee(int employeeId, String employeeName, Integer calculatorTableId, List<Task> tasks) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.calculatorTableId = calculatorTableId;
        this.tasks = tasks;
    }


    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getCalculatorTableId() {
        return calculatorTableId;
    }

    public void setCalculatorTableId(Integer calculatorTableId) {
        this.calculatorTableId = calculatorTableId;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", calculatorTableId=" + calculatorTableId +
                ", tasks=" + tasks +
                '}';
    }
}



