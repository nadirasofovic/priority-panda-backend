package com.pandapriority.be.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pandapriority.be.Workspace;

public interface WorkspaceRepository extends JpaRepository <Workspace, Long> {
}
