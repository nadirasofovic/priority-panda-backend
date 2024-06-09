package com.login.java.project.services;

import com.login.java.project.entities.Task;
import com.login.java.project.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;

@Service
public class TaskManagementService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskManagementService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public String createTask(Task task) {
        taskRepository.save(task);
        return "Task created successfully";
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public String updateTask(Long id, Task task) {
        if (taskRepository.existsById(id)) {
            task.setId(id);
            taskRepository.save(task);
            return "Task updated successfully";
        } else {
            return "Task not found";
        }
    }

    public String deleteTask(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return "Task deleted successfully";
        } else {
            return "Task not found";
        }
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getTasksByPriority(String priority) {
        return taskRepository.findByPriority(priority);
    }

    public List<Task> sortByDueDate() {
        List<Task> tasks = taskRepository.findAll();
        tasks.sort(Comparator.comparing(Task::getDueDate));
        return tasks;
    }

    public List<Task> sortByPriority() {
        List<Task> tasks = taskRepository.findAll();
        tasks.sort(Comparator.comparing(Task::getPriority));
        return tasks;
    }

    public List<Task> getTasksByLabels(List<String> labels) {
        return taskRepository.findByLabelIn(labels);
    }

    public List<Task> getTasksByWorkspaceAndStatus(Long workspaceId, String status) {
        return taskRepository.findByWorkspaceIdAndStatus(workspaceId, status);
    }

    public List<Task> getTasksByStatus(String status) {
        return taskRepository.findByStatus(status);
    }
}
