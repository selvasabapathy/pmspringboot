package home.sabapathy.pm.service.impl;

import home.sabapathy.pm.api.exception.UserException;
import home.sabapathy.pm.service.api.UserService;
import home.sabapathy.pm.service.entity.User;
import home.sabapathy.pm.service.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User add(User user) {
        log.debug("Adding an user... {}", user);
        return userRepository.save(user);
    }

    @Override
    public List<User> edit(User user) {
        log.debug("Saving the edited user... {}", user);
        Set<User> editedUsers = getAll().stream().filter(user1 -> user1.getEmployeeId() == user.getEmployeeId())
                .map(user1 -> {
                    user1.setFirstName(user.getFirstName());
                    user1.setLastName(user.getLastName());
                    return user1;
                }).collect(Collectors.toSet());
        return userRepository.saveAll(editedUsers);
    }

    @Override
    public void delete(long userId) {
        log.debug("Deleting the user with UserID: {}", userId);
        userRepository.deleteByEmployeeId(this.get(userId).getEmployeeId());
    }

    @Override
    public User get(long userId) {
        log.debug("User not found for UserID {}", userId);
        return userRepository.findById(userId).orElseThrow(() -> new UserException(String.format("User not found for UserID \"%s\"", userId)));
    }

    @Override
    public Set<User> getAllWithUniqueEmployeeId() {
        log.debug("Get all users..");
        return userRepository.findUsersWithUniqueEmployeeId();
    }

    @Override
    public List<User> getAll() {
        log.debug("Get all users..");
        return userRepository.findAll();
    }
}
