package home.sabapathy.pm.api.mapper;

import home.sabapathy.pm.api.model.ParentTaskRequest;
import home.sabapathy.pm.api.model.ParentTaskResponse;
import home.sabapathy.pm.api.model.ProjectRequest;
import home.sabapathy.pm.api.model.ProjectResponse;
import home.sabapathy.pm.service.entity.ParentTask;
import home.sabapathy.pm.service.entity.Project;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ParentTaskMapper {
    ParentTask toParentTask(ParentTaskRequest parentTaskRequest);

    ParentTaskResponse toParentTaskResponse(ParentTask parentTask);

    List<ParentTaskResponse> toParentTaskResponse(List<ParentTask> parentTasks);
}
