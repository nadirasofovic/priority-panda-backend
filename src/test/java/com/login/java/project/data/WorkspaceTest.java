package com.login.java.project.data;

import com.login.java.project.Workspace;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WorkspaceTest {
    public static Workspace workspace1() {
        Workspace workspace = new Workspace();
        workspace.setId(1L);
        workspace.setTitle("Workspace 1");
        workspace.setDescription("Workspace 1 Description");
        workspace.setDueDate("15/05/2024");
        workspace.setMembers(Arrays.asList("Nadira", "Dzejla", "Ena", "Hanadi"));

        return workspace;
    }

    public static Workspace workspace2() {
        Workspace workspace = new Workspace();
        workspace.setId(2L);
        workspace.setTitle("Workspace 2");
        workspace.setDescription("Workspace 2 Description");
        workspace.setDueDate("20/12/2024");
        workspace.setMembers(Arrays.asList("Member1", "Member2"));

        return workspace;
    }
}
