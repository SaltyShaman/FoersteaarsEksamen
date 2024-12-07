package org.example.foersteaarseksamen.services;


import org.example.foersteaarseksamen.models.Employee;
import org.example.foersteaarseksamen.models.Employeetasks;
import org.example.foersteaarseksamen.models.Task;
import org.example.foersteaarseksamen.repositories.EmployeetasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeetasksService {

    private final EmployeetasksRepository employeetasksRepository;

    @Autowired
    public EmployeetasksService(EmployeetasksRepository employeetasksRepository) {
        this.employeetasksRepository = employeetasksRepository;
    }

    public void assignTaskToEmployee(int employeeId, Integer taskId) {
        employeetasksRepository.assignTaskToEmployee(employeeId, taskId);
    }

    public List<Employee> findAllEmployees() {
        return employeetasksRepository.findAllEmployees();
    }

    public List<Task> findAllTasks() {
        return employeetasksRepository.findAllTasks();  // Or use custom query if needed
    }


}

