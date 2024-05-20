package com.pandapriority.be;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
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
}
