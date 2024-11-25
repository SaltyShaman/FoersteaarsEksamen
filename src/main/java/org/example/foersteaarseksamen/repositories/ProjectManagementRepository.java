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

    // RowMapper is used for all read operations
    // rs = result set fetching the SQL table names
    private final RowMapper<ProjectManagement> rowMapper = (rs, rowNum) -> new ProjectManagement(
            rs.getLong("project_management_id"),
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

    // Read a single project table
    public ProjectManagement getProjectManagementByProjectName(String projectName) {
        String query = "SELECT * FROM project_management WHERE project_name = ?";
        try {
            return jdbcTemplate.queryForObject(query, new Object[]{projectName}, new RowMapper<ProjectManagement>() {
                @Override
                public ProjectManagement mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return new ProjectManagement(
                            rs.getLong("project_management_id"),
                            rs.getString("project_name"),
                            rs.getString("project_leader")
                    );
                }
            });
        } catch (EmptyResultDataAccessException e) {
            System.out.println("No project found for name: " + projectName);
            return null;
        }
    }

    // List all projects
    public List<ProjectManagement> getAllProjectManagements() {
        String query = "SELECT * FROM project_management";
   //     System.out.println("Number of projects: " + query.length());
        RowMapper rowmapper1 = new BeanPropertyRowMapper(ProjectManagement.class);
        return jdbcTemplate.query(query, rowmapper1);
    }
}

