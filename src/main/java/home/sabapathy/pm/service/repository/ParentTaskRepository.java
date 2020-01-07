package home.sabapathy.pm.service.repository;

import home.sabapathy.pm.service.entity.ParentTask;
import home.sabapathy.pm.service.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentTaskRepository extends JpaRepository<ParentTask, Long> {
}
