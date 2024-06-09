package com.login.java.project;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "workspace_members")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkspaceMember {

    @EmbeddedId
    private WorkspaceMemberId id;

    @ManyToOne
    @MapsId("workspaceId")
    @JoinColumn(name = "workspace_id", nullable = false)
    private Workspace workspace;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}

@Embeddable
class WorkspaceMemberId implements Serializable {

    @Column(name = "workspace_id")
    private Long workspaceId;

    @Column(name = "user_id")
    private Long userId;

    // Default constructor
    public WorkspaceMemberId() {}

    // Parameterized constructor
    public WorkspaceMemberId(Long workspaceId, Long userId) {
        this.workspaceId = workspaceId;
        this.userId = userId;
    }

    // Getters and Setters
    public Long getWorkspaceId() {
        return workspaceId;
    }

    public void setWorkspaceId(Long workspaceId) {
        this.workspaceId = workspaceId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    // Override equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkspaceMemberId that = (WorkspaceMemberId) o;
        return workspaceId.equals(that.workspaceId) && userId.equals(that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workspaceId, userId);
    }
}
