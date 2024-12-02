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
