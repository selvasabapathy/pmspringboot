package home.sabapathy.pm.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor
public class ParentTaskRequest {

    @NotNull(message = "Parent Task ID is required")
    private long parentTaskId;

    @NotEmpty(message = "Fill in Name")
    private String name;
}
