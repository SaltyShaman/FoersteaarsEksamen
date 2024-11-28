package org.example.foersteaarseksamen.repositories;

import org.example.foersteaarseksamen.models.ProjectManagement;
import org.jetbrains.annotations.NotNull;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProjectManagementRepository {

    private final JdbcTemplate jdbcTemplate;

    public ProjectManagementRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createProjectManagement(String projectName, String projectLeader) {
        String query = "INSERT INTO project_management (project_name, project_leader) VALUES (?, ?)";
        jdbcTemplate.update(query, projectName, projectLeader);
    }

    public void deleteProjectManagement(int projectManagementId ) {
        String query = "DELETE FROM project_management WHERE project_management_Id = ?";
        jdbcTemplate.update(query, projectManagementId);
    }


    // List of all projects
    public List<ProjectManagement> getAllProjectManagements() {
        String query = "SELECT * FROM project_management";
        RowMapper rowmapper1 = new BeanPropertyRowMapper(ProjectManagement.class);
        return jdbcTemplate.query(query, rowmapper1);
    }

    public void updateProjectManagement(int projectManagementId, String projectName, String projectLeader) {
        String query = "UPDATE project_management SET project_name = ?, project_leader = ? WHERE project_management_Id = ?";
        jdbcTemplate.update(query, projectName, projectLeader, projectManagementId);
    }



}

