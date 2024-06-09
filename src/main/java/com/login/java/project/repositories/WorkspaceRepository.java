package com.login.java.project.repositories;

import com.login.java.project.entities.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkspaceRepository extends JpaRepository <Workspace, Long> {
}
