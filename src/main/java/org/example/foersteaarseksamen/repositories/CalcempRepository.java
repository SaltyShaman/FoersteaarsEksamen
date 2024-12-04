package org.example.foersteaarseksamen.repositories;

import org.example.foersteaarseksamen.models.Calcemp;
import org.example.foersteaarseksamen.models.Calculator;
import org.example.foersteaarseksamen.models.Client;
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

    public Calcemp getCalcEmpDetails(String calculatorName) {
        String calcSql = "SELECT c.calculator_table_id, c.calculator_name, cl.client_name, cl.client_company, " +
                "pm.project_name, pm.project_leader " +
                "FROM calculator_table c " +
                "JOIN client cl ON c.client_id = cl.client_id " +
                "JOIN project_management pm ON c.project_management_id = pm.project_management_id " +
                "WHERE c.calculator_name = ?";

        Calcemp calcEmp = jdbcTemplate.queryForObject(calcSql, (rs, rowNum) -> {
            Calcemp ce = new Calcemp();
            ce.setCalculatorTableId(rs.getInt("calculator_table_id"));
            ce.setCalculatorName(rs.getString("calculator_name"));
            ce.setClientName(rs.getString("client_name"));
            ce.setClientCompany(rs.getString("client_company"));
            ce.setProjectName(rs.getString("project_name"));
            ce.setProjectLeader(rs.getString("project_leader"));
            return ce;
        }, calculatorName);

        String empSql = "SELECT employee_name FROM employee_table WHERE calculator_table_id = ?";
        List<String> employeeNames = jdbcTemplate.query(empSql, (rs, rowNum) -> rs.getString("employee_name"),
                calcEmp.getCalculatorTableId());

        calcEmp.setEmployeeNames(employeeNames);
        return calcEmp;
    }

    //join statements

    /*
    mål:
    1) læse datasæt efter man vælger lommeregner navn på siden DYNAMISK
    2) læse clientCompany og client på siden afhængigt af lommeregner navn
    3) læse projectName og projectLeader til lommeregneren

    4) læse hvem der er forbundet med hvilke calcualtor tabeller per id
    5) tilføje employee til calculator tabels



     */

}
