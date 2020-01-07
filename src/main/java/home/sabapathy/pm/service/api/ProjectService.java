package home.sabapathy.pm.service.api;

import home.sabapathy.pm.service.entity.Project;
import home.sabapathy.pm.service.entity.User;

import java.util.List;

public interface ProjectService {
    public Project add(Project project);

    public Project edit(Project project);

    public void delete(long projectId);

    public Project get(long projectId);

    public List<Project> getAll();
}
