package home.sabapathy.pm.service.api;

import home.sabapathy.pm.service.entity.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    public User add(User user);

    public List<User> edit(User user);

    public void delete(long userId);

    public User get(long userId);

    public Set<User> getManagers(long projectId);

    public Set<User> getAllWithUniqueEmployeeId();

    public List<User> getAll();
}
