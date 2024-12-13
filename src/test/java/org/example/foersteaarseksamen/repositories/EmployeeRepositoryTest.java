package org.example.foersteaarseksamen;

import org.example.foersteaarseksamen.repositories.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

class EmployeeRepositoryTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateEmployee() {
        String employeeName = "Alice";
        Integer calculatorTableId = 1;

        // Mock the behavior of jdbcTemplate.update
        doNothing().when(jdbcTemplate).update(
                "INSERT INTO employee_table (employee_name, calculator_table_id) VALUES (?, ?)",
                employeeName,
                calculatorTableId
        );

        // Call the method
        employeeRepository.CreateEmployee(employeeName, calculatorTableId);

        // Verify that jdbcTemplate.update was called with the correct arguments
        verify(jdbcTemplate).update(
                "INSERT INTO employee_table (employee_name, calculator_table_id) VALUES (?, ?)",
                employeeName,
                calculatorTableId
        );
    }
}
