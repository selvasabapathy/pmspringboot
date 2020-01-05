package home.sabapathy.pm.api.controller;

import home.sabapathy.pm.api.mapper.UserMapper;
import home.sabapathy.pm.api.model.UserResponse;
import home.sabapathy.pm.service.api.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getUsers() {
        log.debug("Get all users...");
        return new ResponseEntity(userMapper.toUserResponse(userService.getAll()), HttpStatus.OK);
    }
}
