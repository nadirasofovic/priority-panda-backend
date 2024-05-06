package com.login.java.project;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("workspaces")
@RestController
public class WorkspacesController {

    private final WorkspacesService workspacesService;

    public WorkspacesController(WorkspacesService workspacesService) {
        this.workspacesService = workspacesService;
    }

    @GetMapping("list")
    public List<Workspace> getWorkspaces() {
        return this.workspacesService.getWorkspaces();
    }

    @GetMapping("{id}")
    public Workspace getWorkspaces(@PathVariable Long id) {
        return this.workspacesService.getWorkspaceById(id);
    }

    @DeleteMapping("{id}")
    public void deleteWorkspaces(@PathVariable Long id) {
        this.workspacesService.deleteWorkspace(id);
    }

    @PostMapping()
    public Workspace createWorkspace (@RequestBody Workspace workspace) {
        return this.workspacesService.createWorkspace(workspace);
    }

    @PutMapping("{id}")
    public Workspace createWorkspace (@PathVariable Long id, @RequestBody Workspace workspace) {
        return this.workspacesService.updateWorkspace(id,workspace);
    }
}
