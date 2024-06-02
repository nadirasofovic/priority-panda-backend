package com.login.java.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

class TaskManagementServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskManagementService taskManagementService;

    private Task task;

    @BeforeEach
    void setUp() {
        task = new Task();
        task.setId(1L);
        task.setPriority("High");
    }

    @Test
    void createTask_success() {
        when(taskRepository.save(any(Task.class))).thenReturn(task);

        String result = taskManagementService.createTask(task);

        assertEquals("Task created successfully", result);
        verify(taskRepository, times(1)).save(task);
    }

    @Test
    void getTaskById_taskExists() {
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        Task foundTask = taskManagementService.getTaskById(1L);

        assertNotNull(foundTask);
        assertEquals(1L, foundTask.getId());
        verify(taskRepository, times(1)).findById(1L);
    }

    @Test
    void getTaskById_taskDoesNotExist() {
        when(taskRepository.findById(1L)).thenReturn(Optional.empty());

        Task foundTask = taskManagementService.getTaskById(1L);

        assertNull(foundTask);
        verify(taskRepository, times(1)).findById(1L);
    }

    @Test
    void updateTask_success() {
        when(taskRepository.existsById(1L)).thenReturn(true);
        when(taskRepository.save(any(Task.class))).thenReturn(task);

        String result = taskManagementService.updateTask(1L, task);

        assertEquals("Task updated successfully", result);
        verify(taskRepository, times(1)).existsById(1L);
        verify(taskRepository, times(1)).save(task);
    }

    @Test
    void updateTask_taskDoesNotExist() {
        when(taskRepository.existsById(1L)).thenReturn(false);

        String result = taskManagementService.updateTask(1L, task);

        assertEquals("Task not found", result);
        verify(taskRepository, times(1)).existsById(1L);
        verify(taskRepository, times(0)).save(task);
    }

    @Test
    void deleteTask_success() {
        when(taskRepository.existsById(1L)).thenReturn(true);

        String result = taskManagementService.deleteTask(1L);

        assertEquals("Task deleted successfully", result);
        verify(taskRepository, times(1)).existsById(1L);
        verify(taskRepository, times(1)).deleteById(1L);
    }

    @Test
    void deleteTask_taskDoesNotExist() {
        when(taskRepository.existsById(1L)).thenReturn(false);

        String result = taskManagementService.deleteTask(1L);

        assertEquals("Task not found", result);
        verify(taskRepository, times(1)).existsById(1L);
        verify(taskRepository, times(0)).deleteById(1L);
    }

    @Test
    void getAllTasks() {
        when(taskRepository.findAll()).thenReturn(Arrays.asList(task));

        List<Task> tasks = taskManagementService.getAllTasks();

        assertNotNull(tasks);
        assertFalse(tasks.isEmpty());
        verify(taskRepository, times(1)).findAll();
    }

    @Test
    void getTasksByPriority() {
        when(taskRepository.findByPriority("High")).thenReturn(Arrays.asList(task));

        List<Task> tasks = taskManagementService.getTasksByPriority("High");

        assertNotNull(tasks);
        assertFalse(tasks.isEmpty());
        verify(taskRepository, times(1)).findByPriority("High");
    }
}
