package home.sabapathy.pm.service.impl;

import home.sabapathy.pm.api.exception.TaskException;
import home.sabapathy.pm.api.exception.UserException;
import home.sabapathy.pm.service.api.TaskService;
import home.sabapathy.pm.service.api.UserService;
import home.sabapathy.pm.service.entity.Project;
import home.sabapathy.pm.service.entity.Task;
import home.sabapathy.pm.service.entity.User;
import home.sabapathy.pm.service.repository.TaskRepository;
import home.sabapathy.pm.service.repository.UserRepository;
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

    @Autowired
    UserRepository userRepository;

    private void linkTaskToUser(Task task, Task persistedTask) {
        User user = userRepository.findById(task.getUserId()).get();
        if (user.getTask() == null) {
            user.setTask(persistedTask);
        } else {
            // Clone the User to create a new user entry
            user = user.withTask(persistedTask);
            user.setUserId(0);
            user.setProject(null);
        }
        userRepository.save(user);
    }

    private void unlinkTaskFromUser(User currentUser)  {
        log.debug("Unlinking the current user {} from Task {}", currentUser.getUserId(), currentUser.getTask());
        currentUser.setTask(null);
        userRepository.save(currentUser);
    }

    @Override
    public Task add(Task task) {
        log.debug("Adding a task... {}, and to user {}", task, task.getUserId());
        Task persistedTask = taskRepository.save(task);

        linkTaskToUser(task, persistedTask);

        return persistedTask;
    }

    @Override
    public Task edit(Task task) {
        log.debug("Saving the edited task... {}", task);
        Task persistedTask = taskRepository.save(task);

        User currentUser = userRepository.findUsersByTask_TaskId(persistedTask.getTaskId()).get(0).get();
        if (currentUser.getUserId() != task.getUserId()) {
            unlinkTaskFromUser(currentUser);
            linkTaskToUser(task, persistedTask);
        }

        return persistedTask;
    }

    @Override
    public void delete(long taskId) {
        log.debug("Deleting the task with TaskID: {}", taskId);

        User currentUser = userRepository.findUsersByTask_TaskId(taskId).get(0).get();
        unlinkTaskFromUser(currentUser);

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
