package home.sabapathy.pm.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor
public class TaskRequest {

    @NotNull(message = "User ID is required")
    private long taskId;

    @NotNull(message = "Parent Task ID is required")
    private long parentTaskId;

    @NotNull(message = "Project ID is required")
    private long projectId;

    @NotEmpty(message = "Fill in Name")
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private java.util.Date startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date endDate;

    @Min(value = 1, message = "Priority between 1 and 30")
    @Max(value = 30, message = "Priority between 1 and 30")
    private int priority;

    private boolean status;
}
