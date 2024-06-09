package com.login.java.project.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "analytics")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Analytics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "analytics_id")
    private Long analyticsId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "completion_rate", nullable = false)
    private double completionRate;

    @Column(name = "time_spent", nullable = false)
    private double timeSpent;

    @Column(name = "login_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date loginDate;
}
