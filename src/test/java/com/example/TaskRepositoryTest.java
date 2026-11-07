package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository repository;

    @Test
    public void testSaveAndFindTask() {

        Task task = new Task();

        task.setTitle("Java Assignment");
        task.setDescription("Complete Spring Boot");

        // Save task
        Task saved = repository.save(task);

        // Retrieve task
        Task result =
            repository.findById(saved.getId()).orElse(null);

        // Verify
        assertNotNull(saved.getId());
        assertNotNull(result);

        assertEquals("Java Assignment", result.getTitle());

        System.out.println("Task saved successfully!");
    }
}