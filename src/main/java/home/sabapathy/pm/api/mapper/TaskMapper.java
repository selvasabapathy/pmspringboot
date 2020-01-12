package home.sabapathy.pm.api.mapper;

import home.sabapathy.pm.api.model.TaskRequest;
import home.sabapathy.pm.api.model.TaskResponse;
import home.sabapathy.pm.api.model.UserRequest;
import home.sabapathy.pm.api.model.UserResponse;
import home.sabapathy.pm.service.api.ParentTaskService;
import home.sabapathy.pm.service.api.ProjectService;
import home.sabapathy.pm.service.entity.Task;
import home.sabapathy.pm.service.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", uses = { ParentTaskService.class, ProjectService.class })
public interface TaskMapper {

    @Mapping(target = "parentTask", source = "parentTaskId", qualifiedByName = {"ParentTaskService", "findParentTaskById"})
    @Mapping(target = "project", source = "projectId", qualifiedByName = {"ProjectService", "findProjectById"})
    Task toTask(TaskRequest taskRequest);

    TaskResponse toTaskResponse(Task task);

    List<TaskResponse> toTaskResponse(Set<Task> tasks);

    List<TaskResponse> toTaskResponse(List<Task> tasks);
}
