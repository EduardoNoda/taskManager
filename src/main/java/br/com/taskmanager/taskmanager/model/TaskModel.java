package br.com.taskmanager.taskmanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Entity
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long id;
    @NotEmpty(message = "{task.title.not.empty}")
    private String title;
    @NotEmpty(message = "{task.description.not.empty}")
    @Column(length = 1200)
    @Size(max = 1200, message = "{task.description.size}")
    private String description;
    @NotNull(message = "{task.date.not.null}")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private boolean isCompleted;
    private String creatorName;

    public TaskModel(@NotEmpty String title,
                     @NotEmpty @Size String description,
                     @NotNull LocalDate date,
                     boolean isCompleted,
                     String creatorName) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.isCompleted = isCompleted;
        this.creatorName = creatorName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TaskModel taskModel = (TaskModel) o;
        return isCompleted == taskModel.isCompleted && Objects.equals(id, taskModel.id) && Objects.equals(title, taskModel.title) && Objects.equals(description, taskModel.description) && Objects.equals(date, taskModel.date) && Objects.equals(creatorName, taskModel.creatorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, date, isCompleted, creatorName);
    }
}
