package home.sabapathy.pm.service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(schema = "pm", name = "task")
@Data @NoArgsConstructor @AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private long taskId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_task_id")
    private ParentTask parentTask;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @Column(name = "priority")
    private int priority;

    @Column(name = "status")
    private boolean status;
}
