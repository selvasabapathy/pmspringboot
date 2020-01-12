package home.sabapathy.pm.service.api;

import home.sabapathy.pm.service.entity.Project;
import home.sabapathy.pm.service.entity.User;
import org.mapstruct.Named;

import java.util.List;

@Named("ProjectService")
public interface ProjectService {
    public Project add(Project project);

    public Project edit(Project project);

    public void delete(long projectId);

    @Named("findProjectById")
    public Project get(long projectId);

    public List<Project> getAll();
}
