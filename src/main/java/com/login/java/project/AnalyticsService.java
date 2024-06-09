package com.login.java.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalyticsService {

    @Autowired
    private AnalyticsRepository analyticsRepository;

    public List<Analytics> getAnalyticsByUserId(Long userId) {
        return analyticsRepository.findByUserId(userId);
    }

    public Analytics saveAnalytics(Analytics analytics) {
        return analyticsRepository.save(analytics);
    }
}
