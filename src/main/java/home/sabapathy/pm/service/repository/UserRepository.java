package home.sabapathy.pm.service.repository;

import home.sabapathy.pm.service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT pu.* FROM pm.user pu INNER JOIN (SELECT employee_id, MIN(user_id) as user_id FROM pm.user GROUP BY employee_id) AS pu2 on pu.user_id = pu2.user_id", nativeQuery = true)
    Set<User> findUsersWithUniqueEmployeeId();

    Set<User> findUsersByProject_ProjectId(long projectId);

    Set<User> findUsersByTask_TaskId(long taskId);

     void deleteByEmployeeId(Long employeeId);
}
