package com.example.todowithgpt;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoService todoService;

    @Test
    public void testGetTodo() {
        Todo todo = new Todo();
        todo.setId(1L);
        when(todoRepository.findById(1L)).thenReturn(Optional.of(todo));

        Todo foundTodo = todoService.getTodo(1L).get();

        assertEquals(foundTodo.getId(), todo.getId());
        verify(todoRepository, times(1)).findById(1L);
    }

    @Test
    public void testGetAllTodos() {
        Todo todo1 = new Todo();
        Todo todo2 = new Todo();
        when(todoRepository.findAll()).thenReturn(Arrays.asList(todo1, todo2));

        List<Todo> todos = todoService.getAllTodos();

        assertEquals(2, todos.size());
        verify(todoRepository, times(1)).findAll();
    }

    @Test
    public void testCreateTodo() {
        Todo todo = new Todo();
        when(todoRepository.save(any(Todo.class))).thenReturn(todo);

        Todo createdTodo = todoService.createTodo(new Todo());

        assertEquals(createdTodo, todo);
        verify(todoRepository, times(1)).save(any(Todo.class));
    }

    @Test
    public void testUpdateTodo() {
        Todo todo = new Todo();
        when(todoRepository.save(any(Todo.class))).thenReturn(todo);

        Todo updatedTodo = todoService.updateTodo(new Todo());

        assertEquals(updatedTodo, todo);
        verify(todoRepository, times(1)).save(any(Todo.class));
    }

    @Test
    public void testDeleteTodo() {
        Long id = 1L;
        doNothing().when(todoRepository).deleteById(id);

        todoService.deleteTodo(id);

        verify(todoRepository, times(1)).deleteById(id);
    }
}