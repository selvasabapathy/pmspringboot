package home.sabapathy.pm.service.impl;

import home.sabapathy.pm.api.exception.TaskException;
import home.sabapathy.pm.api.exception.UserException;
import home.sabapathy.pm.service.api.TaskService;
import home.sabapathy.pm.service.api.UserService;
import home.sabapathy.pm.service.entity.Task;
import home.sabapathy.pm.service.entity.User;
import home.sabapathy.pm.service.repository.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public Task add(Task task) {
        log.debug("Adding a task... {}", task);
        return taskRepository.save(task);
    }

    @Override
    public Task edit(Task task) {
        log.debug("Saving the edited task... {}", task);
        return taskRepository.save(task);
    }

    @Override
    public void delete(long taskId) {
        log.debug("Deleting the task with TaskID: {}", taskId);
        taskRepository.deleteById(taskId);
    }

    @Override
    public Task get(long projectId, long taskId) {
        log.debug("Get Task for TaskID {}", taskId);
        return taskRepository.findTaskByProject_ProjectIdAndTaskId(projectId, taskId).orElseThrow(() -> new TaskException(String.format("Task not found for TaskID \"%s\"", taskId)));
    }

    @Override
    public Set<Task> getAll(long projectId) {
        return taskRepository.findTasksByProject_ProjectId(projectId);
    }
}
