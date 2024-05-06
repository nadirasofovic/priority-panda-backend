package com.login.java.project;


public class Workspace {
    private long id;
    private String title;
    private String description;
    private String dueDate;
    private String[] members;

    public long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDueDate() {
        return this.dueDate;
    }

    public String[] getMembers() {
        return this.members;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setDueDate(final String dueDate) {
        this.dueDate = dueDate;
    }

    public void setMembers(final String[] members) {
        this.members = members;
    }

    public Workspace(final long id, final String title, final String description, final String dueDate, final String[] members) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.members = members;
    }
}
