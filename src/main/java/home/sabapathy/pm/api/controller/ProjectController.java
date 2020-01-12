package home.sabapathy.pm.api.controller;

import home.sabapathy.pm.api.mapper.ProjectMapper;
import home.sabapathy.pm.api.mapper.UserMapper;
import home.sabapathy.pm.api.model.ProjectRequest;
import home.sabapathy.pm.api.model.ProjectResponse;
import home.sabapathy.pm.api.model.UserRequest;
import home.sabapathy.pm.api.model.UserResponse;
import home.sabapathy.pm.service.api.ProjectService;
import home.sabapathy.pm.service.api.UserService;
import home.sabapathy.pm.service.entity.Project;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j

@RestController
@Validated
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @Autowired
    ProjectMapper projectMapper;

    @PostMapping("/projects/{managerId}")
    public ResponseEntity<UserResponse> add(@PathVariable long managerId, @Valid @RequestBody ProjectRequest projectRequest) {
        log.debug("Add an user... {}, and managerId {}", projectRequest, managerId);
        Project project = projectMapper.toProject(projectRequest);
        project.setManagerId(managerId);
        return new ResponseEntity(projectMapper.toProjectResponse(projectService.add(project)), HttpStatus.CREATED);
    }

    @PutMapping("/projects/{managerId}")
    public ResponseEntity<ProjectResponse> edit(@PathVariable long managerId, @Valid @RequestBody ProjectRequest projectRequest) {
        log.debug("Edit the project... {}, and managerId {}", projectRequest, managerId);
        Project project = projectMapper.toProject(projectRequest);
        project.setManagerId(managerId);
        return new ResponseEntity(projectMapper.toProjectResponse(projectService.edit(project)), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/projects/{projectId}")
    public ResponseEntity<Void> delete(@Valid @PathVariable long projectId) {
        log.debug("Delete the project with ProjectID: {}", projectId);
        projectService.delete(projectId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/projects/{projectId}")
    public ResponseEntity<ProjectResponse> get(@PathVariable long projectId) {
        log.debug("Get the Project with ProjectID: {}", projectId);
        return new ResponseEntity(projectMapper.toProjectResponse(projectService.get(projectId)), HttpStatus.OK);
    }

    @GetMapping("/projects")
    public ResponseEntity<List<ProjectResponse>> getProjects() {
        log.debug("Get all projects...");
        return new ResponseEntity(projectMapper.toProjectResponse(projectService.getAll()), HttpStatus.OK);
    }
}
