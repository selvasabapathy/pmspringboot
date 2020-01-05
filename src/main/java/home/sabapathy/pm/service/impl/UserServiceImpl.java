package home.sabapathy.pm.service.impl;

import home.sabapathy.pm.service.api.UserService;
import home.sabapathy.pm.service.entity.User;
import home.sabapathy.pm.service.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAll() {
        log.debug("Get all users..");
        return userRepository.findAll();
    }
}
