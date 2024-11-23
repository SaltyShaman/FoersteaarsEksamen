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
    private final RowMapper<ProjectManagement> rowMapper = (rs, rowNum) -> new ProjectManagement(
            rs.getString("project_name"),
            rs.getString("project_leader")
    );

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


    //Read a single table
    public ProjectManagement getProjectManagementByProjectName(String projectName) {
        String query = "SELECT * FROM project_management WHERE project_name = ?";
        try {
            return jdbcTemplate.queryForObject(query, rowMapper, projectName);
        } catch (EmptyResultDataAccessException e) {
            return null; // return null incase no project found
        }
    }


    //List is because it contains all SQL tables
    public List<ProjectManagement> getAllProjectManagements() {
        String query = "SELECT * FROM project_management";
        return jdbcTemplate.query(query, rowMapper);
    }
}
