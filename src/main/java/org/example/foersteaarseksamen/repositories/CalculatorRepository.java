package org.example.foersteaarseksamen.repositories;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CalculatorRepository {

    private final JdbcTemplate jdbcTemplate;

    public CalculatorRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    /* list of operations:
        Create (MVP)
        1: fetch client ID
        2: fetch project management ID
        3: create
    */

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

}
