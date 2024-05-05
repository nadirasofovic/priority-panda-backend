package com.pandabek;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaskManagementService {

    private static Map<Long, Task> tasks = new HashMap<>();
    private static Long taskIdCounter = 0L;
    static {
        Task task1 = new Task();
        task1.setId(++taskIdCounter);
        task1.setTitle("Meeting");
        task1.setDescription("Hanadi and Ena need details");
        task1.setDueDate(LocalDate.now().plusDays(7));
        task1.setPriority("High");
        task1.setLabel("Work");
        tasks.put(taskIdCounter, task1);

        Task task2 = new Task();
        task2.setId(++taskIdCounter);
        task2.setTitle("Pay Bills");
        task2.setDescription("Water and Heating");
        task2.setDueDate(LocalDate.now().plusDays(3));
        task2.setPriority("Medium");
        task2.setLabel("Finance");
        tasks.put(taskIdCounter, task2);
    }
    public String createTask(Task task) {
        task.setId(++taskIdCounter);
        tasks.put(taskIdCounter, task);
        return "Task created successfully";
    }

    public Task getTaskById(Long id) {
        return tasks.get(id);
    }

    public String updateTask(Long id, Task task) {
        if (tasks.containsKey(id)) {
            task.setId(id);
            tasks.put(id, task);
            return "Task updated successfully";
        } else {
            return "Task not found";
        }
    }

    public String deleteTask(Long id) {
        if (tasks.containsKey(id)) {
            tasks.remove(id);
            return "Task deleted successfully";
        } else {
            return "Task not found";
        }
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }
}
