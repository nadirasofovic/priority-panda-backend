package com.login.java.project;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping({"/tasks"})
@RestController
public class TaskManagementController {
    @Autowired
    private final TaskManagementService taskManagementService;

    public TaskManagementController(TaskManagementService taskManagementService) {
        this.taskManagementService = taskManagementService;
    }

    @PostMapping
    public String createTask(@RequestBody Task task) {
        return this.taskManagementService.createTask(task);
    }

    @GetMapping({"/{id}"})
    public Task getTaskById(@PathVariable Long id) {
        return this.taskManagementService.getTaskById(id);
    }

    @PutMapping({"/{id}"})
    public String updateTask(@PathVariable Long id, @RequestBody Task task) {
        return this.taskManagementService.updateTask(id, task);
    }

    @DeleteMapping({"/{id}"})
    public String deleteTask(@PathVariable Long id) {
        return this.taskManagementService.deleteTask(id);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return this.taskManagementService.getAllTasks();
    }

    @PostMapping({"/add"})
    public String addTask(@RequestBody Task task) {
        return this.taskManagementService.createTask(task);
    }

    @PutMapping({"/update/{id}"})
    public String updateExistingTask(@PathVariable Long id, @RequestBody Task task) {
        return this.taskManagementService.updateTask(id, task);
    }

    @DeleteMapping({"/delete/{id}"})
    public String deleteExistingTask(@PathVariable Long id) {
        return this.taskManagementService.deleteTask(id);
    }
}

