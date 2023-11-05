package com.example.todowithgpt;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class TodoControllerTest {

    @Mock
    private TodoService todoService;

    @InjectMocks
    private TodoController todoController;

    @Test
    public void testGetTodo() {
        Todo todo = new Todo();
        todo.setId(1L);
        when(todoService.getTodo(1L)).thenReturn(Optional.of(todo));

        ResponseEntity<Todo> response = todoController.getTodo(1L);

        assertEquals(response.getBody().getId(), todo.getId());
        verify(todoService, times(1)).getTodo(1L);
    }

    @Test
    public void testGetAllTodos() {
        Todo todo1 = new Todo();
        Todo todo2 = new Todo();
        when(todoService.getAllTodos()).thenReturn(Arrays.asList(todo1, todo2));

        ResponseEntity<List<Todo>> response = todoController.getAllTodos();

        assertEquals(2, response.getBody().size());
        verify(todoService, times(1)).getAllTodos();
    }

    @Test
    public void testCreateTodo() {
        Todo todo = new Todo();
        when(todoService.createTodo(any(Todo.class))).thenReturn(todo);

        ResponseEntity<Todo> response = todoController.createTodo(new Todo());

        assertEquals(response.getBody(), todo);
        verify(todoService, times(1)).createTodo(any(Todo.class));
    }

    @Test
    public void testUpdateTodo() {
        Todo todo = new Todo();
        todo.setId(1L);
        when(todoService.updateTodo(any(Todo.class))).thenReturn(todo);

        ResponseEntity<Todo> response = todoController.updateTodo(1L, new Todo());

        assertEquals(response.getBody(), todo);
        verify(todoService, times(1)).updateTodo(any(Todo.class));
    }

    @Test
    public void testDeleteTodo() {
        Long id = 1L;
        doNothing().when(todoService).deleteTodo(id);

        ResponseEntity<Void> response = todoController.deleteTodo(id);

        assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);
        verify(todoService, times(1)).deleteTodo(id);
    }
}