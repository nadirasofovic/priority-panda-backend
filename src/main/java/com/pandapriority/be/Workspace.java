package com.pandapriority.be;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Workspace {
    private long id;
    private String title;
    private String description;
    private String dueDate;
    private String[] members;
}
