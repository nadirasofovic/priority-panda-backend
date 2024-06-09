package com.login.java.project.services;

import com.login.java.project.entities.Badge;
import com.login.java.project.repositories.BadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BadgeService {

    @Autowired
    private BadgeRepository badgeRepository;

    public List<Badge> getBadgesByUserId(Long userId) {
        return badgeRepository.findByUserId(userId);
    }

    public Badge createBadge(Badge badge) {
        return badgeRepository.save(badge);
    }
}
