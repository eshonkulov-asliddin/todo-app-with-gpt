package com.example.todowithgpt;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {

    @Test
    public void testTodo() {
        // Create a new Todo object
        Todo todo = new Todo();
        todo.setId(1L);
        todo.setTitle("Test Todo");
        todo.setDescription("Test Description");

        // Test the getId method
        assertEquals(1L, todo.getId());

        // Test the getTitle method
        assertEquals("Test Todo", todo.getTitle());

        // Test the getDescription method
        assertEquals("Test Description", todo.getDescription());
    }
}