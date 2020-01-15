package home.sabapathy.pm.api.model;

import home.sabapathy.pm.service.entity.ParentTask;
import home.sabapathy.pm.service.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor
public class TaskResponse {

    private long taskId;
    private long userId;
    private ParentTask parentTask;
    private Project project;
    private String name;
    private Date startDate;
    private Date endDate;
    private int priority;
    private boolean status;
}
