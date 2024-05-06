package com.login.java.project;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PersonalList {

    private Long Id;
    private String title;
    private String description;
    private String dueDate;
    private String priority;
    private String label;


    public PersonalList(Long id, String title, String description, String dueDate, String priority, String label) {
        this.Id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.label = label;
    }


    public void toString(String description) {
    }
}



