package home.sabapathy.pm.service.api;

import home.sabapathy.pm.service.entity.User;

import java.util.List;

public interface UserService {
    public User add(User user);

    public User edit(User user);

    public void delete(long userId);

    public User get(long userId);

    public List<User> getAll();
}
