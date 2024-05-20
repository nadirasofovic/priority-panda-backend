package com.login.java.project;


import java.time.LocalDate;

public class Task {
    private Long id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private String priority;
    private String label;

    public Task() {
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public LocalDate getDueDate() {
        return this.dueDate;
    }

    public String getPriority() {
        return this.priority;
    }

    public String getLabel() {
        return this.label;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Task(final Long id, final String title, final String description, final LocalDate dueDate, final String priority, final String label) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.label = label;
    }
}

