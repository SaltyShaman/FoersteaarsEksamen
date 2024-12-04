package org.example.foersteaarseksamen.controllers;

import org.example.foersteaarseksamen.services.ProjectManagementServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProjectManagementController {

    private final ProjectManagementServices projectManagementServices;

    public ProjectManagementController(ProjectManagementServices projectManagementServices) {
        this.projectManagementServices = projectManagementServices;
    }
// index returning fungerer
// select all is also a button to go the table
//createPost is how you add project_managements to SQL

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/selectAllFromProjectManagement")
    public String selectAllFromProjectManagement(Model model) {
        model.addAttribute("projectManagements", projectManagementServices.getAllProjectManagements());
        return "projects-overview";
    }


    //go to form
    @GetMapping("/create")
    public String showCreateProjectForm(Model model) {
        return "register-new-project";
    }

    // create post is adding project_managements to the database
    //redirects to index afterwards
    @PostMapping("/createPost")
    public String createProject(@RequestParam String projectName, @RequestParam String projectLeader) {
        projectManagementServices.createProjectManagement(projectName, projectLeader);
        return "redirect:/selectAllFromProjectManagement";
    }

    @PostMapping("/deleteProject")
        public String showDeleteProjectForm(@RequestParam int projectManagementId) {
        projectManagementServices.deleteProjectManagement(projectManagementId);
            return "redirect:/selectAllFromProjectManagement";
    }


    @GetMapping("/updateProject")
    public String showUpdateProjectForm(Model model) {
        return "update-project";
    }

    @PostMapping("/updateProject")
    public String updateProject(@RequestParam String projectName,
                                @RequestParam String projectLeader,
                                @RequestParam String oldProjectName) {
        projectManagementServices.updateProjectManagement(projectName, projectLeader, oldProjectName);
        return "redirect:/selectAllFromProjectManagement";
    }
}