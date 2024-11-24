package org.example.foersteaarseksamen;

import org.example.foersteaarseksamen.models.ProjectManagement;
import org.example.foersteaarseksamen.repositories.ProjectManagementRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestPropertySource(properties = {
        "spring.datasource.url=${url}",
        "spring.datasource.username=${username}",
        "spring.datasource.password=${passwoerd}"
})
@SpringBootTest
public class ProjectManagementRepositoryTest {




    @Autowired
    private ProjectManagementRepository projectManagementRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testGetAllProjectManagements() {
        // Act: Retrieve the list of projects
        List<ProjectManagement> projects = projectManagementRepository.getAllProjectManagements();

        // Assert: Check that the list is not null
        assertNotNull(projects, "The list of projects should not be null.");

        // Assert: Check the size of the list
        System.out.println("Number of projects: " + projects.size());
        assertTrue(projects.size() >= 0, "The list of projects should have at least 0 items.");
    }

    @Test
    public void testgetProjectManagementByProjectName() {
        String projectName = "Test";

        ProjectManagement project = projectManagementRepository.getProjectManagementByProjectName(projectName);

        assertNotNull(project);  // Check that the project was found
        assertEquals("Test", project.getProjectName());  // Validate the returned project
    }

    @Test
    public void testDatabaseConnectionWithOutQuery() {
        // Test that the jdbcTemplate is correctly configured
        assertNotNull(jdbcTemplate);
        // Additional database connection testing can be done here
    }


}
