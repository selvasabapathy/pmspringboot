package home.sabapathy.pm.service.repository;

import home.sabapathy.pm.service.entity.ParentTask;
import home.sabapathy.pm.service.entity.Project;
import home.sabapathy.pm.service.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Set<Task> findTasksByParentTask_ParentTaskId(long parentTaskId);
    Set<Task> findTasksByProject_ProjectId(long projectId);
    Optional<Task> findTaskByProject_ProjectIdAndTaskId(long projectId, long taskId);
}
