package com.login.java.project.data;

import com.login.java.project.User;
import com.login.java.project.Workspace;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WorkspaceTest {
    public static Workspace workspace1() {
        Workspace workspace = new Workspace();
        workspace.setId(1L);
        workspace.setTitle("Workspace 1");
        workspace.setDescription("Workspace 1 Description");
        workspace.setDueDate("15/05/2024");

        List<User> members = Arrays.asList(
                new User(1L, "nadira@example.com", "Nadira", "password1", null),
                new User(2L, "dzejla@example.com", "Dzejla", "password2", null),
                new User(3L, "ena@example.com", "Ena", "password3", null),
                new User(4L, "hanadi@example.com", "Hanadi", "password4", null)
        );

        workspace.setMembers(members);

        return workspace;
    }

    public static Workspace workspace2() {
        Workspace workspace = new Workspace();
        workspace.setId(2L);
        workspace.setTitle("Workspace 2");
        workspace.setDescription("Workspace 2 Description");
        workspace.setDueDate("20/12/2024");

        List<User> members = Arrays.asList(
                new User(5L, "member1@example.com", "Member1", "password5", null),
                new User(6L, "member2@example.com", "Member2", "password6", null)
        );

        workspace.setMembers(members);

        return workspace;
    }
}
