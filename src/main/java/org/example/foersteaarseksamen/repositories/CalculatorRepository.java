package org.example.foersteaarseksamen.repositories;


import org.example.foersteaarseksamen.models.Calculator;
import org.example.foersteaarseksamen.models.Client;
import org.example.foersteaarseksamen.models.ProjectManagement;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CalculatorRepository {

    private final JdbcTemplate jdbcTemplate;

    public CalculatorRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }




    //inspired by ChatGPT dec 1 -> reconfigured to only look for company name
    public int getClientId(String clientCompany) {
        String sql = "SELECT client_id FROM client WHERE client_company = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, clientCompany);
    }

    //inspired by ChatGPT dec 1 -> reconfigured to only look for project name
    public int getProjectManagementId (String projectName) {
        String sql = "SELECT project_management_id FROM project_management WHERE project_name = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, projectName);
    }

    public void createCalculator (String calculatorName, int client_id, int projectManagementId) {
        String query = "INSERT INTO calculator_table (calculator_name, client_id, project_management_id) VALUES (?, ?, ?)";
        jdbcTemplate.update(query, calculatorName, client_id,  projectManagementId);
    }

    public List<Client> getAllClients() {
        String query = "SELECT * FROM client";
        RowMapper rowmapper = new BeanPropertyRowMapper(Client.class);
        return jdbcTemplate.query(query, rowmapper);
    }

    public List<ProjectManagement> getAllProjects() {
        String query = "SELECT * FROM project_management";
        RowMapper rowmapper = new BeanPropertyRowMapper(ProjectManagement.class);
        return jdbcTemplate.query(query, rowmapper);
    }

    public List<Calculator> findAllCalculators() {
        String query = "SELECT * FROM calculator_table";
        RowMapper rowmapper = new BeanPropertyRowMapper(Calculator.class);
        return jdbcTemplate.query(query, rowmapper);
    }
}
