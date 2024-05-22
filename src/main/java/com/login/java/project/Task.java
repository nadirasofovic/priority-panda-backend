package com.login.java.project;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "task")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

    public class Task {
        @Id
        @GeneratedValue
        private long id;

        @Column(name = "title")
        private String title;

        @Column(name = "description")
        private String description;

        @Column(name = "dueDate")
        private String dueDate;

        @Column(name = "priority")
        private String priority;

        @Column(name = "label")
        private String label;
    }




