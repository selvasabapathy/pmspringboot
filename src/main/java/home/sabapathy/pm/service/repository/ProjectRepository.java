package home.sabapathy.pm.service.repository;

import home.sabapathy.pm.service.entity.Project;
import home.sabapathy.pm.service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
