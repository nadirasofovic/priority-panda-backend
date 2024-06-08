package com.login.java.project;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ListRepository extends JpaRepository<List, Long> {
    List<List> findByOwner(User owner);
    List<List> findByIsPrivate(boolean isPrivate);
}
