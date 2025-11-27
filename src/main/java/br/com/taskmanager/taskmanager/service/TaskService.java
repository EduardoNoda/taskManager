package br.com.taskmanager.taskmanager.service;

import br.com.taskmanager.taskmanager.model.TaskModel;
import org.springframework.scheduling.config.Task;

import java.util.List;

public interface TaskService {
    void createTask(TaskModel task);

    void updateTask(Long id, TaskModel task);

    void deleteTask(Long id);

    List<TaskModel> findAll();

    List<TaskModel> findByOwnerOrderByDateDesc(String ownerName);

    void setTaskCompleted(Long id);

    void setTaskNotCompleted(Long id);

    TaskModel getTaskById(Long taskId);
}
