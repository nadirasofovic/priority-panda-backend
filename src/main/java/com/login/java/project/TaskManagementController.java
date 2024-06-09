package com.login.java.project;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/priority/{priority}")
    public List<Task> getTasksByPriority(@PathVariable String priority) {
        return this.taskManagementService.getTasksByPriority(priority);
    }

    @GetMapping("/sort/byDueDate")
    public List<Task> sortByDueDate() {
        return this.taskManagementService.sortByDueDate();
    }

    @GetMapping("/sort/byPriority")
    public List<Task> sortByPriority() {
        return this.taskManagementService.sortByPriority();
    }

    @GetMapping("/labels")  // Add this endpoint
    public List<Task> getTasksByLabels(@RequestParam List<String> labels) {
        return this.taskManagementService.getTasksByLabels(labels);
    }

    @GetMapping("/workspace/{workspaceId}/status/{status}")
    public List<Task> getTasksByWorkspaceAndStatus(@PathVariable Long workspaceId, @PathVariable String status) {
        return taskManagementService.getTasksByWorkspaceAndStatus(workspaceId, status);
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable String status) {
        return taskManagementService.getTasksByStatus(status);
    }
}
