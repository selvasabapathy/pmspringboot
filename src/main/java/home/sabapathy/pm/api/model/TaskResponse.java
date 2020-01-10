package home.sabapathy.pm.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor
public class TaskResponse {

    private long taskId;
    private String name;
    private Date startDate;
    private Date endDate;
    private int priority;
    private boolean status;
}
