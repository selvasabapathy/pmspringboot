package home.sabapathy.pm.service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(schema = "pm", name = "parent_task")
@Data @NoArgsConstructor @AllArgsConstructor
public class ParentTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parent_task_id")
    private long parentTaskId;

    @Column(name = "name", nullable = false)
    private String name;
}
