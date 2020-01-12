package home.sabapathy.pm.service.api;

import home.sabapathy.pm.service.entity.ParentTask;
import home.sabapathy.pm.service.entity.Project;
import org.mapstruct.Named;

import java.util.List;

@Named("ParentTaskService")
public interface ParentTaskService {
    public ParentTask add(ParentTask parentTask);

    public ParentTask edit(ParentTask parentTask);

    public void delete(long parentTaskId);

    @Named("findParentTaskById")
    public ParentTask get(long parentTaskId);

    public List<ParentTask> getAll();
}
