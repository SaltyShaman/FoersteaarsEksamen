package org.example.foersteaarseksamen.repositories;

import org.example.foersteaarseksamen.models.ProjectManagement;
import org.jetbrains.annotations.NotNull;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectManagementRepository {

    private final JdbcTemplate jdbcTemplate;

    public ProjectManagementRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    //RowMapper is used for all read operations
    //rs = result set fetching the SQL table names
    private final RowMapper<ProjectManagement> rowMapper = (rs, rowNum) -> {
        ProjectManagement project = new ProjectManagement(
                rs.getString("project_name"),
                rs.getString("project_leader")
        );
        project.setProjectMannagementID(rs.getLong("project_management_id"));
        return project;
    };

    public void createProjectManagement(@NotNull ProjectManagement projectManagement) {
        String query = "INSERT INTO project_management (project_name, project_leader) VALUES (?, ?)";
        jdbcTemplate.update(query, projectManagement.getProjectName(), projectManagement.getProjectLeader());
    }

    public void updateProjectManagement(@NotNull ProjectManagement projectManagement) {
        String query = "UPDATE project_management SET project_leader = ? WHERE project_name = ?";
        jdbcTemplate.update(query, projectManagement.getProjectLeader(), projectManagement.getProjectName());
    }

    public void deleteProjectManagement(@NotNull ProjectManagement projectManagement) {
        String query = "DELETE FROM project_management WHERE project_name = ?";
        jdbcTemplate.update(query, projectManagement.getProjectName());
    }


    //Read a single project table
    public ProjectManagement getProjectManagementByProjectName(String projectName) {
        String query = "SELECT * FROM project_management WHERE project_name = ?";
        try {
            System.out.println("Executing query: " + query + " with parameter: " + projectName);
            return jdbcTemplate.queryForObject(query, rowMapper, projectName);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("No project found for name: " + projectName);
            return null; //incase there is no project with specified name
        }
    }



    //List is because it contains all SQL tables
    public List<ProjectManagement> getAllProjectManagements() {
        String query = "SELECT * FROM project_management";
        System.out.println("Number of projects: " + query.length() );
        return jdbcTemplate.query(query, rowMapper);
    }
}
