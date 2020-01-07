package home.sabapathy.pm.service.impl;

import home.sabapathy.pm.api.exception.ProjectException;
import home.sabapathy.pm.service.api.ProjectService;
import home.sabapathy.pm.service.api.UserService;
import home.sabapathy.pm.service.entity.Project;
import home.sabapathy.pm.service.repository.ProjectRepository;
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

    @Override
    public Project add(Project project) {
        log.debug("Adding a project... {}", project);
        return projectRepository.save(project);
    }

    @Override
    public Project edit(Project project) {
        log.debug("Saving the edited project... {}", project);
        return projectRepository.save(project);    }

    @Override
    public void delete(long projectId) {
        log.debug("Deleting the project with projectId: {}", projectId);
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
