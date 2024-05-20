package com.login.java.project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/badges")
public class BadgeController {

    @Autowired
    private BadgeService badgeService;

    @GetMapping("/user/{userId}")
    public List<Badge> getBadgesByUserId(@PathVariable Long userId) {
        return badgeService.getBadgesByUserId(userId);
    }
}
