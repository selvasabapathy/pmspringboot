package home.sabapathy.pm.api.model;

import home.sabapathy.pm.service.entity.Project;
import home.sabapathy.pm.service.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data @NoArgsConstructor @AllArgsConstructor
public class UserResponse {

    private long userId;
    private long employeeId;
    private String firstName;
    private String lastName;
}
