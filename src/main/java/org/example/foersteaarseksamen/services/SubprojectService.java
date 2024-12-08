package org.example.foersteaarseksamen.services;


import org.example.foersteaarseksamen.models.Subproject;
import org.example.foersteaarseksamen.repositories.SubprojectRepository;
import org.example.foersteaarseksamen.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubprojectService {

    private final SubprojectRepository subprojectRepository;

    public SubprojectService(SubprojectRepository subprojectRepository) {
        this.subprojectRepository = subprojectRepository;
    }

    public List<Subproject> findAllSubprojects(){
        return subprojectRepository.findAllSubprojects();
    }

    public void assignEmployeeToSubproject(Integer employeeId, Integer subprojectId) {
        // Call the repository method to handle the database insertion
        subprojectRepository.assignEmployeeToSubproject(employeeId, subprojectId);
    }


}
