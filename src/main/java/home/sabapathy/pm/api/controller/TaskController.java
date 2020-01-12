package home.sabapathy.pm.api.controller;

import home.sabapathy.pm.api.mapper.TaskMapper;
import home.sabapathy.pm.api.model.TaskResponse;
import home.sabapathy.pm.api.model.TaskRequest;
import home.sabapathy.pm.api.model.TaskResponse;
import home.sabapathy.pm.api.model.UserResponse;
import home.sabapathy.pm.service.api.TaskService;
import home.sabapathy.pm.service.entity.Task;
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
public class TaskController {

    @Autowired
    TaskService taskService;

    @Autowired
    TaskMapper taskMapper;

    @PostMapping("tasks")
    public ResponseEntity<TaskResponse> add(@Valid @RequestBody TaskRequest taskRequest) {
        log.debug("Add a Task... {}", taskRequest);
        return new ResponseEntity(taskMapper.toTaskResponse(taskService.add(taskMapper.toTask(taskRequest))), HttpStatus.CREATED);
    }

    @PutMapping("/tasks/{taskId}")
    public ResponseEntity<TaskResponse> edit(@Valid @PathVariable long taskId, @Valid @RequestBody TaskRequest taskRequest) {
        log.debug("Edit the task... {}", taskRequest);
        return new ResponseEntity(taskMapper.toTaskResponse(taskService.edit(taskMapper.toTask(taskRequest))), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/tasks/{taskId}")
    public ResponseEntity<Void> delete(@Valid @PathVariable long taskId) {
        log.debug("Delete the task with TaskID: {}", taskId);
        taskService.delete(taskId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/tasks/{projectId}/{taskId}")
    public ResponseEntity<TaskResponse> get(@Valid @PathVariable long projectId, @Valid @PathVariable long taskId) {
        log.debug("Get the Task with TaskID: {}", taskId);
        return new ResponseEntity(taskMapper.toTaskResponse(taskService.get(projectId, taskId)), HttpStatus.OK);
    }

    @GetMapping("/tasks/{projectId}")
    public ResponseEntity<List<TaskResponse>> getTasks(@Valid @PathVariable long projectId) {
        log.debug("Get all tasks...");
        return new ResponseEntity(taskMapper.toTaskResponse(taskService.getAll(projectId)), HttpStatus.OK);
    }
}
