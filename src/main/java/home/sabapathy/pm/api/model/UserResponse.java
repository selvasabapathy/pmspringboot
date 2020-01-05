package home.sabapathy.pm.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class UserResponse {
    long userId;
    long employeeId;
    String firstName;
    String lastName;
}
