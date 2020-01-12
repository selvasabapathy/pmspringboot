package home.sabapathy.pm.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor
public class ProjectRequest {

    @NotNull(message = "Project ID is required")
    private long projectId;

    @NotEmpty(message = "Fill in Name")
    private String name;

    @Min(value = 0, message = "No. of tasks between 1 and 10")
    @Max(value = 10, message = "No. of tasks between 1 and 10")
    private int taskCount;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date endDate;

    @Min(value = 1, message = "Priority between 1 and 30")
    @Max(value = 30, message = "Priority between 1 and 30")
    private int priority;

    private boolean completed;
}
