package com.login.java.project.controllers;

import com.login.java.project.services.AnalyticsService;
import com.login.java.project.entities.Analytics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    @Autowired
    private AnalyticsService analyticsService;

    @GetMapping("/user/{userId}")
    public List<Analytics> getAnalyticsByUserId(@PathVariable Long userId) {
        return analyticsService.getAnalyticsByUserId(userId);
    }

    @PostMapping
    public Analytics saveAnalytics(@RequestBody Analytics analytics) {
        return analyticsService.saveAnalytics(analytics);
    }
}
