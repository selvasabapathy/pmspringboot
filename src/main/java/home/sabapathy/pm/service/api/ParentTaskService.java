package home.sabapathy.pm.service.api;

import home.sabapathy.pm.service.entity.ParentTask;
import home.sabapathy.pm.service.entity.Project;

import java.util.List;

public interface ParentTaskService {
    public ParentTask add(ParentTask project);

    public ParentTask edit(ParentTask project);

    public void delete(long projectId);

    public ParentTask get(long projectId);

    public List<ParentTask> getAll();
}
