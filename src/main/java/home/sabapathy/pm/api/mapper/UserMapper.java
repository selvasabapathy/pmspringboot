package home.sabapathy.pm.api.mapper;

import home.sabapathy.pm.api.model.UserRequest;
import home.sabapathy.pm.api.model.UserResponse;
import home.sabapathy.pm.service.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserRequest userRequest);

    UserResponse toUserResponse(User user);

    List<UserResponse> toUserResponse(List<User> users);
}
