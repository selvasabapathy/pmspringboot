package home.sabapathy.pm.service.impl;

import home.sabapathy.pm.api.exception.ProjectException;
import home.sabapathy.pm.service.api.ProjectService;
import home.sabapathy.pm.service.entity.Project;
import home.sabapathy.pm.service.entity.User;
import home.sabapathy.pm.service.repository.ProjectRepository;
import home.sabapathy.pm.service.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    UserRepository userRepository;

    private void linkProjectToManager(Project project, Project persistedProject) {
        User user = userRepository.findById(project.getManagerId()).get();
        if (user.getProject() == null) {
            user.setProject(persistedProject);
        } else {
            // Clone the User to create a new user entry
            user = user.withProject(persistedProject);
            user.setUserId(0);
            user.setTask(null);
        }
        userRepository.save(user);
    }

    private void unlinkProjectFromManager(User currentManager)  {
        log.debug("Unlinking the current manager {} from Project {}", currentManager.getUserId(), currentManager.getProject());
        currentManager.setProject(null);
        userRepository.save(currentManager);
    }

    @Override
    public Project add(Project project) {
        log.debug("Adding a project... {}, and managerId {}", project, project.getManagerId());
        Project persistedProject = projectRepository.save(project);

        linkProjectToManager(project, persistedProject);

        return persistedProject;
    }

    @Override
    public Project edit(Project project) {
        log.debug("Saving the edited project... {}", project);
        Project persistedProject = projectRepository.save(project);

        User currentManager = userRepository.findUsersByProject_ProjectId(persistedProject.getProjectId()).get(0).get();
        if (currentManager.getUserId() != project.getManagerId()) {
            unlinkProjectFromManager(currentManager);
            linkProjectToManager(project, persistedProject);
        }

        return persistedProject;
    }

    @Override
    public void delete(long projectId) {
        log.debug("Deleting the project with projectId: {}", projectId);

        User currentManager = userRepository.findUsersByProject_ProjectId(projectId).get(0).get();
        unlinkProjectFromManager(currentManager);

        projectRepository.deleteById(projectId);
    }

    @Override
    public Project get(long projectId) {
        log.debug("User not found for projectId {}", projectId);
        return projectRepository.findById(projectId).orElseThrow(() -> new ProjectException(String.format("Project not found for projectId \"%s\"", projectId)));
    }

    @Override
    public List<Project> getAll() {
        log.debug("Get all users..");
        return projectRepository.findAll();
    }
}
