package home.sabapathy.pm.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data @NoArgsConstructor @AllArgsConstructor
public class UserRequest {

    @NotNull(message = "User ID is required")
    long userId;

    @NotNull(message = "Employee ID is required")
    long employeeId;

    @NotEmpty(message = "Fill in First Name")
    String firstName;

    @NotEmpty(message = "Fill in Last Name")
    String lastName;
}
