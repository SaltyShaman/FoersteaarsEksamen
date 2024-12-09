package org.example.foersteaarseksamen.repositories;


import org.example.foersteaarseksamen.models.Employee;
import org.example.foersteaarseksamen.models.Subproject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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

    public List<Subproject> findSubprojectsByCalculatorName(String calculatorName) {
        String query = """
            SELECT sp.subproject_id, sp.subproject_name, sp.project_management_id
            FROM subprojects sp
            JOIN project_management pm ON sp.project_management_id = pm.project_management_Id
            JOIN calculator_table ct ON pm.project_management_Id = ct.project_management_id
            WHERE ct.calculator_name = ?
        """;

        return jdbcTemplate.query(query, (rs, rowNum) -> new Subproject(
                rs.getInt("subproject_id"),
                rs.getString("subproject_name"),
                rs.getInt("project_management_id")
        ), calculatorName);
    }

    public List<Employee> findEmployeesBySubprojectId(Integer subprojectId) {
        // SQL query to join employee_subprojects and employees tables
        String query = """
        SELECT e.employee_id, e.employee_name, e.calculator_table_id
        FROM employee_subprojects es
        INNER JOIN employee_table e ON es.employee_id = e.employee_id
        WHERE es.subproject_id = ?
    """;

        // Execute the query and map the result to a list of Employee objects
        return jdbcTemplate.query(query, (rs, rowNum) -> new Employee(
                rs.getInt("employee_id"),
                rs.getString("employee_name"),
                rs.getObject("calculator_table_id", Integer.class), // Handling potential null values
                new ArrayList<>() // Providing an empty list for tasks
        ), subprojectId);
    }


}