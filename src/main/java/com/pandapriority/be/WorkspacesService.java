package com.pandapriority.be;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class WorkspacesService {

    private long id = 0;

    private List<Workspace> workspaces = new ArrayList<>();

    public WorkspacesService() {
        this.workspaces.add(new Workspace(this.id++,"Workspace 1", "Workspace 1 description",
                "16/04/2024", new String[]{"Nadira","Nadira", "Nadira"}));
        this.workspaces.add(new Workspace(this.id++,"Workspace 2", "Workspace 2 description",
                "17/04/2024", new String[]{"Dzejla","Dzejla", "Dzejla"}));
        this.workspaces.add(new Workspace(this.id++,"Workspace 2", "Workspace 2 description",
                "18/04/2024", new String[]{"Ena","Ena", "Ena"}));
        this.workspaces.add(new Workspace(this.id++,"Workspace 2", "Workspace 2 description",
                "19/04/2024", new String[]{"Hanadi","Hanadi", "Hanadi"}));
    }

    public List<Workspace> getWorkspaces() {
        return this.workspaces;
    }

    public Workspace getWorkspaceById(long id) {
        List<Workspace> workspaceList = this.workspaces;
        for (int i = 0; i < workspaceList.size(); i++) {
            Workspace workspace = workspaceList.get(i);
            if (workspace.getId() == id) {
                return workspace;
            }
        }
        return null;
    }

    public void deleteWorkspace (long id) {
        List<Workspace> workspaceList = this.workspaces;
        for (int i = 0; i < workspaceList.size(); i++) {
            Workspace workspace = workspaceList.get(i);
            if (workspace.getId() == id) {
                this.workspaces.remove(i);
                return;
            }
        }
    }

    public Workspace createWorkspace(Workspace workspace) {
        workspace.setId(this.id++);
        this.workspaces.add(workspace);
        return workspace;
    }

    public Workspace updateWorkspace(Long id, Workspace workspace) {
        Workspace current = this.getWorkspaceById(id);
        if (current == null) {
            return null;
        }
        current.setTitle(workspace.getTitle());
        current.setDescription(workspace.getDescription());
        current.setDueDate(workspace.getDueDate());
        current.setMembers(workspace.getMembers());
        return current;
    }
}
