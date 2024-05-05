package com.pandapriority.be;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequestMapping("/tasks")
@RestController
public class TaskManagementController {

    @Autowired
    private final TaskManagementService taskManagementService;

    public TaskManagementController(TaskManagementService taskManagementService) {
        this.taskManagementService = taskManagementService;
    }


    @PostMapping()
    public String createTask(@RequestBody Task task) {
        return taskManagementService.createTask(task);
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskManagementService.getTaskById(id);
    }

    @PutMapping("/{id}")
    public String updateTask(@PathVariable Long id, @RequestBody Task task) {
        return taskManagementService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        return taskManagementService.deleteTask(id);
    }

    @GetMapping()
    public List<Task> getAllTasks() {
        return taskManagementService.getAllTasks();
    }

    @PostMapping("/add")
    public String addTask(@RequestBody Task task) {
        return taskManagementService.createTask(task);
    }

    @PutMapping("/update/{id}")
    public String updateExistingTask(@PathVariable Long id, @RequestBody Task task) {
        return taskManagementService.updateTask(id, task);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteExistingTask(@PathVariable Long id) {
        return taskManagementService.deleteTask(id);
    }
}
