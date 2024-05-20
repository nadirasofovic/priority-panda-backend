package com.login.java.project;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Table(name = "workspace")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Workspace {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "dueDate")
    private String dueDate;

    @ElementCollection
    @CollectionTable(name = "workspace_members", joinColumns = @JoinColumn(name = "workspace_id"))
    @Column(name = "members")
    private List<String> members;

}
