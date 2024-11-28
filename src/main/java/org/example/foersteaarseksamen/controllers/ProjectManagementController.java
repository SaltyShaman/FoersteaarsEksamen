package org.example.foersteaarseksamen.controllers;

import org.springframework.ui.Model;
import org.example.foersteaarseksamen.models.ProjectManagement;
import org.example.foersteaarseksamen.services.ProjectManagementServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        return "redirect:/";
    }

    @PostMapping("/deleteProject")
        public String showDeleteProjectForm(@RequestParam int projectManagementId) {
        projectManagementServices.deleteProjectManagement(projectManagementId);
            return "redirect:/selectAllFromProjectManagement";
    }

    @GetMapping("/updateProject")
    public String showUpdateProjectForm(Model model){
        return "update-project";
    }

    @PostMapping("/update")
    public String updateProject(@RequestParam int projectManagementId,
                                @RequestParam String projectName,
                                @RequestParam String projectLeader) {
        projectManagementServices.updateProjectManagement(projectManagementId, projectName, projectLeader);
        return "redirect:/selectAllFromProjectManagement";
    }

/*
    @GetMapping("/updateForm")
    public String showUpdateForm(Model model,
                                 @RequestParam int projectManagementId,) {
        model.addAttribute("projectManagementId", projectManagementId);
        model.addAttribute("projectName", projectName);
        model.addAttribute("projectLeader", projectLeader);

        return "update-project";
    }
*/

}