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
    public User edit(User user) {
        log.debug("Saving the edited user... {}", user);
        return userRepository.save(user);
    }

    @Override
    public void delete(long userId) {
        log.debug("Deleting the user with UserID: {}", userId);
        userRepository.deleteById(userId);
    }

    @Override
    public User get(long userId) {
        log.debug("User not found for UserID {}", userId);
        return userRepository.findById(userId).orElseThrow(() -> new UserException(String.format("User not found for UserID \"%s\"", userId)));
    }

    @Override
    public List<User> getAll() {
        log.debug("Get all users..");
        return userRepository.findAll();
    }
}
