package org.example.foersteaarseksamen.services;

import org.example.foersteaarseksamen.models.ProjectManagement;
import org.example.foersteaarseksamen.repositories.ProjectManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectManagementServices {

    private final ProjectManagementRepository projectManagementRepository;

    public ProjectManagementServices(ProjectManagementRepository projectManagementRepository) {
        this.projectManagementRepository = projectManagementRepository;
    }

    public void createProjectManagement(String projectName, String projectLeader) {
        projectManagementRepository.createProjectManagement(projectName, projectLeader);
    }

    public void deleteProjectManagement(int projectManagementId) {
        projectManagementRepository.deleteProjectManagement(projectManagementId);
    }




    public void updateProjectManagement(String projectName, String projectLeader, int projectManagementId) {
        projectManagementRepository.updateProjectManagement(projectName, projectLeader, projectManagementId);
    }

    public ProjectManagement getProjectById(int projectManagementId) {
        return projectManagementRepository.findById(projectManagementId);
    }

    public List<ProjectManagement> getAllProjectManagements() {
        return projectManagementRepository.getAllProjectManagements();
    }
}
