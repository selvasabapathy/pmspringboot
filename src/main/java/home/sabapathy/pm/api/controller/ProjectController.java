package home.sabapathy.pm.api.controller;

import home.sabapathy.pm.api.mapper.ProjectMapper;
import home.sabapathy.pm.api.mapper.UserMapper;
import home.sabapathy.pm.api.model.ProjectRequest;
import home.sabapathy.pm.api.model.ProjectResponse;
import home.sabapathy.pm.api.model.UserRequest;
import home.sabapathy.pm.api.model.UserResponse;
import home.sabapathy.pm.service.api.ProjectService;
import home.sabapathy.pm.service.api.UserService;
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

    @PostMapping("/projects")
    public ResponseEntity<UserResponse> add(@Valid @RequestBody ProjectRequest projectRequest) {
        log.debug("Add an user... {}", projectRequest);
        return new ResponseEntity(projectMapper.toProjectResponse(projectService.add(projectMapper.toProject(projectRequest))), HttpStatus.CREATED);
    }

    @PutMapping("/projects/{projectId}")
    public ResponseEntity<ProjectResponse> edit(@Valid @RequestBody ProjectRequest projectRequest) {
        log.debug("Edit the project... {}", projectRequest);
        return new ResponseEntity(projectMapper.toProjectResponse(projectService.add(projectMapper.toProject(projectRequest))), HttpStatus.ACCEPTED);
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
