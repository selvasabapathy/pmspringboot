package home.sabapathy.pm.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data @NoArgsConstructor @AllArgsConstructor
public class UserRequest {

    @NotNull(message = "User ID is required")
    private long userId;

    @NotNull(message = "Employee ID is required")
    private long employeeId;

    @NotEmpty(message = "Fill in First Name")
    private String firstName;

    @NotEmpty(message = "Fill in Last Name")
    private String lastName;
}
