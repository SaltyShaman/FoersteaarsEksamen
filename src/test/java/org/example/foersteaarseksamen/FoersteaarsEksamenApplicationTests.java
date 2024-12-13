package org.example.foersteaarseksamen;

import org.example.foersteaarseksamen.models.Employee;
import org.example.foersteaarseksamen.models.Subproject;
import org.example.foersteaarseksamen.repositories.SubprojectRepository;
import org.example.foersteaarseksamen.services.SubprojectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class FoersteaarsEksamenApplicationTests {

    @Mock
    private SubprojectRepository subprojectRepository;

    @InjectMocks
    private SubprojectService subprojectService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPerformanceWithEmployeesUsingExistingMethods() {
        int[] employeeCounts = {10, 25, 50};

        for (int count : employeeCounts) {
            // Mock data
            Subproject subproject = new Subproject(1, "Performance Test Subproject", 1);

            List<Employee> employees = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                employees.add(new Employee(i + 1, "Employee " + i, null, new ArrayList<>()));
            }

            // Mock repository behavior
            when(subprojectRepository.findEmployeesBySubprojectId(subproject.getSubprojectId())).thenReturn(employees);

            // Measure performance
            long startTime = System.currentTimeMillis();
            List<Employee> result = subprojectRepository.findEmployeesBySubprojectId(subproject.getSubprojectId());
            long duration = System.currentTimeMillis() - startTime;

            System.out.println("Employee Count: " + count + ", Query Duration: " + duration + "ms");

            assertEquals(count, result.size());
        }
    }
}
