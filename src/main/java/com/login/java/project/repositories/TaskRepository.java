package com.login.java.project.repositories;

import com.login.java.project.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByPriority(String priority);
    List<Task> findByLabelIn(List<String> labels);
    List<Task> findByWorkspaceIdAndStatus(Long workspaceId, String status);
    List<Task> findByStatus(String status);
}
