package com.login.java.project;
import org.springframework.stereotype.Service;
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
