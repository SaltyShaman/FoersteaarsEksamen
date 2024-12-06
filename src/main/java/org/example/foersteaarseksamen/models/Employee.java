package org.example.foersteaarseksamen.models;

import java.util.List;

public class Employee {

        private int employeeId;  // PRIMARY KET
        private String employeeName;
        private Integer tasksId;  // FOREIGN KEY FOR TASKS, nullable
        private Integer calculatorTableId;  //FOREIGN KEY FOR PROJECT TOOL (calculator table), nullable

    public Employee() {
    }

        public Employee(int employeeId, String employeeName, Integer tasksId, Integer calculatorTableId) {
            this.employeeId = employeeId;
            this.employeeName = employeeName;
            this.tasksId = tasksId;
            this.calculatorTableId = calculatorTableId;
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

        public int getTasksId() {
            return tasksId;
        }

        public void setTasksId(Integer tasksId) {
            this.tasksId = tasksId;
        }

        public Integer getCalculatorTableId() {
            return calculatorTableId;
        }

        public void setCalculatorTableId(Integer calculatorTableId) {
            this.calculatorTableId = calculatorTableId;
        }

        // toString method for easy display of the object
        @Override
        public String toString() {
            return "Employee{" +
                    "employeeId=" + employeeId +
                    ", employeeName='" + employeeName + '\'' +
                    ", tasksId=" + tasksId +
                    ", calculatorTableId=" + calculatorTableId +
                    '}';
        }
    }



