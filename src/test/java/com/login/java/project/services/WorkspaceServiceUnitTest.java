package com.login.java.project.services;

import com.login.java.project.Workspace;
import com.login.java.project.WorkspaceRepository;
import com.login.java.project.WorkspacesService;
import com.login.java.project.data.WorkspaceTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
public class WorkspaceServiceUnitTest {

    @MockBean
    private WorkspaceRepository workspaceRepository;

    @TestConfiguration
    static class WorkspacesServiceTestConfiguration {
        @Bean
        @Primary
        public WorkspacesService workspacesService(WorkspaceRepository workspaceRepository) {
            return new WorkspacesService(workspaceRepository);
        }
    }

    @Autowired
    private WorkspacesService workspacesService;

    @Test
    public void givenWorkspaces_whenGetWorkspaces_thenReturnWorkspaces() {
        Mockito.when(workspaceRepository.findAll())
                .thenReturn(List.of(WorkspaceTest.workspace1(), WorkspaceTest.workspace2()));

        List<Workspace> result = workspacesService.getWorkspaces();

        assertThat(result).hasSize(2);
    }

    @Test
    public void givenNoWorkspaces_whenGetWorkspaces_thenReturnNoWorkspaces() {
        Mockito.when(workspaceRepository.findAll())
                .thenReturn(Collections.EMPTY_LIST);

        List<Workspace> result = workspacesService.getWorkspaces();

        assertThat(result).isEmpty();
    }

    @Test
    public void givenWorkspaces_whenCreateWorkspace_thenWorkspaceIsCreated() {
        Workspace inputWorkspace = WorkspaceTest.workspace1();
        Workspace outputWorkspace = WorkspaceTest.workspace1();

        Mockito.when(workspaceRepository.save(any(Workspace.class)))
                .thenReturn(outputWorkspace);

        Workspace result = workspacesService.createWorkspace(inputWorkspace);

        assertThat(result).isNotNull();
        assertThat(result.getTitle()).isEqualTo(inputWorkspace.getTitle());
    }

    @Test
    public void givenWorkspaceId_whenGetWorkspaceById_thenReturnWorkspace() {
        Workspace workspace = WorkspaceTest.workspace1();
        Mockito.when(workspaceRepository.findById(workspace.getId()))
                .thenReturn(Optional.of(workspace));

        Workspace result = workspacesService.getWorkspaceById(workspace.getId());

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(workspace.getId());
    }

    @Test
    public void givenNonExistentWorkspaceId_whenGetWorkspaceById_thenReturnNull() {
        Mockito.when(workspaceRepository.findById(any(Long.class)))
                .thenReturn(Optional.empty());

        Workspace result = workspacesService.getWorkspaceById(1L);

        assertThat(result).isNull();
    }

    @Test
    public void givenWorkspaceId_whenDeleteWorkspace_thenWorkspaceIsDeleted() {
        long workspaceId = 1L;
        workspacesService.deleteWorkspace(workspaceId);

        Mockito.verify(workspaceRepository, Mockito.times(1)).deleteById(workspaceId);
    }

    @Test
    public void givenWorkspaceIdAndUpdatedWorkspace_whenUpdateWorkspace_thenWorkspaceIsUpdated() {
        Workspace existingWorkspace = WorkspaceTest.workspace1();
        Workspace updatedWorkspace = WorkspaceTest.workspace2();

        Mockito.when(workspaceRepository.findById(existingWorkspace.getId()))
                .thenReturn(Optional.of(existingWorkspace));
        Mockito.when(workspaceRepository.save(any(Workspace.class)))
                .thenReturn(updatedWorkspace);

        Workspace result = workspacesService.updateWorkspace(existingWorkspace.getId(), updatedWorkspace);

        assertThat(result).isNotNull();
        assertThat(result.getTitle()).isEqualTo(updatedWorkspace.getTitle());
        assertThat(result.getDescription()).isEqualTo(updatedWorkspace.getDescription());
        assertThat(result.getDueDate()).isEqualTo(updatedWorkspace.getDueDate());
        assertThat(result.getMembers()).isEqualTo(updatedWorkspace.getMembers());
    }

    @Test
    public void givenNonExistentWorkspaceId_whenUpdateWorkspace_thenReturnNull() {
        Workspace updatedWorkspace = WorkspaceTest.workspace2();

        Mockito.when(workspaceRepository.findById(any(Long.class)))
                .thenReturn(Optional.empty());

        Workspace result = workspacesService.updateWorkspace(1L, updatedWorkspace);

        assertThat(result).isNull();
    }
}

