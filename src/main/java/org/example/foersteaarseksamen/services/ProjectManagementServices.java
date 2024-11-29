package org.example.foersteaarseksamen.services;

import org.example.foersteaarseksamen.models.ProjectManagement;
import org.example.foersteaarseksamen.repositories.ProjectManagementRepository;
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




    public void updateProjectManagement(String projectName, String projectLeader, String oldProjectName) {
        projectManagementRepository.updateProjectManagement(projectName, projectLeader, oldProjectName);
    }

    public ProjectManagement getProjectById(int projectManagementId) {
        return projectManagementRepository.findById(projectManagementId);
    }

    public List<ProjectManagement> getAllProjectManagements() {
        return projectManagementRepository.getAllProjectManagements();
    }
}
