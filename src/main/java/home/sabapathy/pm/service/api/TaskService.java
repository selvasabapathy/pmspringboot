package home.sabapathy.pm.service.api;

import home.sabapathy.pm.api.model.ProjectResponse;
import home.sabapathy.pm.api.model.TaskRequest;
import home.sabapathy.pm.api.model.UserResponse;
import home.sabapathy.pm.service.entity.Project;
import home.sabapathy.pm.service.entity.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

public interface TaskService {
    public Task add(Task task);

    public Task edit(Task task);

    public void delete(long taskId);

    public Task get(long projectId, long taskId);

    public Set<Task> getAll(long projectId);
}
