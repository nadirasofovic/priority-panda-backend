package com.login.java.project;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CollaboratorRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
