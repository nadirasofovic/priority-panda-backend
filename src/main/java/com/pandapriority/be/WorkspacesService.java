package com.pandapriority.be;

import com.pandapriority.be.repositories.WorkspaceRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WorkspacesService {

    private long id = 0;

    private List<Workspace> workspaces = new ArrayList<>();

    private WorkspaceRepository workspaceRepository;

    public WorkspacesService(WorkspaceRepository workspaceRepository) {
        this.workspaceRepository = workspaceRepository;
    }

    public List<Workspace> getWorkspaces() {
        return this.workspaceRepository.findAll();
    }

    public Workspace getWorkspaceById(long id) {
        Optional<Workspace> workspace = this.workspaceRepository.findById(id);
        return workspace.orElse(null);
    }

    public void deleteWorkspace (long id) {
        this.workspaceRepository.deleteById(id);
    }

    public Workspace createWorkspace(Workspace workspace) {
        return this.workspaceRepository.save(workspace);
    }

    public Workspace updateWorkspace(Long id, Workspace workspace) {
        Optional<Workspace> optionalCurrent = this.workspaceRepository.findById(id);
        if (!optionalCurrent.isPresent()) {
            return null;
        }

        Workspace current = optionalCurrent.get();
        current.setTitle(workspace.getTitle());
        current.setDescription(workspace.getDescription());
        current.setDueDate(workspace.getDueDate());
        current.setMembers(workspace.getMembers());

        return this.workspaceRepository.save(current);
    }
}
