package org.example.foersteaarseksamen.repositories;

import org.example.foersteaarseksamen.models.Calcemp;
import org.example.foersteaarseksamen.models.Calculator;
import org.example.foersteaarseksamen.models.Client;
import org.example.foersteaarseksamen.models.Employee;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


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
        String empSql = "SELECT employee_id, employee_name, work_area, task, estimated_work_hours_per_employee " +
                "FROM employee_table WHERE calculator_table_id = ?";

        return jdbcTemplate.query(empSql, (rs, rowNum) -> {
            Employee employee = new Employee();
            employee.setEmployeeId(rs.getInt("employee_id"));
            employee.setEmployeeName(rs.getString("employee_name"));
            employee.setWorkArea(rs.getString("work_area"));
            employee.setTask(rs.getString("task"));
            employee.setEstimatedHoursPerEmployee(rs.getInt("estimated_work_hours_per_employee"));
            return employee;
        }, calculatorTableId);
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


    //join statements

    /*
    mål:

    4) læse hvem der er forbundet med hvilke calcualtor tabeller per id
    5) tilføje employee til calculator tabels



     */

}
