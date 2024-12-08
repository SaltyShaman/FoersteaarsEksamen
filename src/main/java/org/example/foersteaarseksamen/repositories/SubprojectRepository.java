package org.example.foersteaarseksamen.repositories;


import org.example.foersteaarseksamen.models.Subproject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubprojectRepository {

    private final JdbcTemplate jdbcTemplate;

    public SubprojectRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Subproject> findAllSubprojects() {
        // SQL query to fetch all subprojects
        String query = "SELECT * FROM subprojects";

        // Query the database and map the result to a list of Subproject objects
        return jdbcTemplate.query(query, (rs, rowNum) -> {
            // Mapping the result set to Subproject object
            return new Subproject(
                    rs.getInt("subproject_id"),
                    rs.getString("subproject_name"),
                    rs.getInt("project_management_id")
            );
        });
    }

    public void assignEmployeeToSubproject(Integer employeeId, Integer subprojectId) {
        String query = "INSERT INTO employee_subprojects (employee_id, subproject_id) VALUES (?, ?)";
        jdbcTemplate.update(query, employeeId, subprojectId);
    }

}
