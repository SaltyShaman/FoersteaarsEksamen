package org.example.foersteaarseksamen.repositories;

import org.example.foersteaarseksamen.models.*;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class CalcempRepository {

    private final JdbcTemplate jdbcTemplate;

    public CalcempRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Calculator> findAllCalculators() {
        String query = "SELECT * FROM calculator_table";
        RowMapper rowmapper = new BeanPropertyRowMapper(Calculator.class);
        return jdbcTemplate.query(query, rowmapper);
    }

    // SQL query aquired from ChatGPt Dec 4 and tested in database
    public Calcemp getClientAndProjectData(String calculatorName) {
        String calcSql = "SELECT c.calculator_table_id, c.calculator_name, cl.client_name, cl.client_company, " +
                "pm.project_name, pm.project_leader " +
                "FROM calculator_table c " +
                "JOIN client cl ON c.client_id = cl.client_id " +
                "JOIN project_management pm ON c.project_management_id = pm.project_management_id " +
                "WHERE c.calculator_name = ?";

        return jdbcTemplate.queryForObject(calcSql, (rs, rowNum) -> {
            Calcemp ce = new Calcemp();
            ce.setCalculatorTableId(rs.getInt("calculator_table_id"));
            ce.setCalculatorName(rs.getString("calculator_name"));
            ce.setClientName(rs.getString("client_name"));
            ce.setClientCompany(rs.getString("client_company"));
            ce.setProjectName(rs.getString("project_name"));
            ce.setProjectLeader(rs.getString("project_leader"));
            return ce;
        }, calculatorName);
    }


    //Inspired by ChatGPT dec 4
    public List<Employee> getEmployeeDetails(int calculatorTableId) {
        String empSql = """
        SELECT e.employee_id, e.employee_name, e.calculator_table_id,
               t.tasks_id, t.task_name, t.estimated_work_hours_per_task
        FROM employee_table e
        LEFT JOIN employee_tasks et ON e.employee_id = et.employee_id
        LEFT JOIN tasks t ON et.tasks_id = t.tasks_id
        WHERE e.calculator_table_id = ?
    """;

        Map<Integer, Employee> employeeMap = new HashMap<>();

        try {
            jdbcTemplate.query(empSql, rs -> {
                int employeeId = rs.getInt("employee_id");

                // Retrieve or create the employee object
                Employee employee = employeeMap.computeIfAbsent(employeeId, id -> {
                    try {
                        return new Employee(
                                id,
                                rs.getString("employee_name"),
                                rs.getInt("calculator_table_id"),
                                new ArrayList<>()
                        );
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                });

                // Add tasks if they exist
                int taskId = rs.getInt("tasks_id");
                if (!rs.wasNull()) {
                    Task task = new Task(
                            taskId,
                            rs.getString("task"),
                            rs.getInt("estimated_work_hours_per_task")
                    );
                    employee.getTasks().add(task);
                }
            }, calculatorTableId);
        } catch (DataAccessException e) {
            e.printStackTrace(); // Log or handle the exception as needed
        }

        return new ArrayList<>(employeeMap.values());
    }




    public Calcemp getCalcEmpDetails(String calculatorName) {
        // Fetch client and project data
        Calcemp calcEmp = getClientAndProjectData(calculatorName);

        // Fetch employee data (full employee details)
        List<Employee> employees = getEmployeeDetails(calcEmp.getCalculatorTableId());
        calcEmp.setEmployees(employees);  // total sum: list of employees and client and project data

        return calcEmp;
    }

    public void attachEmployeeToCalculatorTableId(int employeeId, int calculatorTableId) {
        String query = "UPDATE employee_table SET calculator_table_id = ? WHERE employee_id = ?";
        jdbcTemplate.update(query, calculatorTableId, employeeId); // Corrected parameter order
    }

    public List<Employee> getAllEmployees() {
        String query = "SELECT * FROM employee_table";
        RowMapper rowmapper = new BeanPropertyRowMapper(Employee.class);
        return jdbcTemplate.query(query, rowmapper);
    }

    public List<Calculator> getAllCalculators() {
        String query = "SELECT * FROM calculator_table";
        RowMapper rowmapper = new BeanPropertyRowMapper(Calculator.class);
        return jdbcTemplate.query(query, rowmapper);
    }

}