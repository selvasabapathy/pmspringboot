package home.sabapathy.pm.api.mapper;

import home.sabapathy.pm.api.model.ProjectRequest;
import home.sabapathy.pm.api.model.ProjectResponse;
import home.sabapathy.pm.service.entity.Project;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    Project toProject(ProjectRequest projectRequest);

    ProjectResponse toProjectResponse(Project project);

    List<ProjectResponse> toProjectResponse(List<Project> projects);
}
