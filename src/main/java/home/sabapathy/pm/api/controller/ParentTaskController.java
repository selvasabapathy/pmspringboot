package home.sabapathy.pm.api.controller;

import home.sabapathy.pm.api.mapper.ParentTaskMapper;
import home.sabapathy.pm.api.model.*;
import home.sabapathy.pm.service.api.ParentTaskService;
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
public class ParentTaskController {

    @Autowired
    ParentTaskService parentTaskService;

    @Autowired
    ParentTaskMapper parentTaskMapper;

    @PostMapping("/parentTasks")
    public ResponseEntity<UserResponse> add(@Valid @RequestBody ParentTaskRequest parentTaskRequest) {
        log.debug("Add a ParentTask... {}", parentTaskRequest);
        return new ResponseEntity(parentTaskMapper.toParentTaskResponse(parentTaskService.add(parentTaskMapper.toParentTask(parentTaskRequest))), HttpStatus.CREATED);
    }

    @PutMapping("/parentTasks/{parentTaskId}")
    public ResponseEntity<ParentTaskResponse> edit(@Valid @RequestBody ParentTaskRequest parentTaskRequest) {
        log.debug("Edit the ParentTask... {}", parentTaskRequest);
        return new ResponseEntity(parentTaskMapper.toParentTaskResponse(parentTaskService.add(parentTaskMapper.toParentTask(parentTaskRequest))), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/parentTasks/{parentTaskId}")
    public ResponseEntity<Void> delete(@Valid @PathVariable long parentTaskId) {
        log.debug("Delete the ParentTask with parentTaskId: {}", parentTaskId);
        parentTaskService.delete(parentTaskId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/parentTasks/{parentTaskId}")
    public ResponseEntity<ParentTaskResponse> get(@PathVariable long parentTaskId) {
        log.debug("Get the ParentTask with parentTaskId: {}", parentTaskId);
        return new ResponseEntity(parentTaskMapper.toParentTaskResponse(parentTaskService.get(parentTaskId)), HttpStatus.OK);
    }

    @GetMapping("/parentTasks")
    public ResponseEntity<List<ParentTaskResponse>> getProjects() {
        log.debug("Get all ParentTasks...");
        return new ResponseEntity(parentTaskMapper.toParentTaskResponse(parentTaskService.getAll()), HttpStatus.OK);
    }
}
