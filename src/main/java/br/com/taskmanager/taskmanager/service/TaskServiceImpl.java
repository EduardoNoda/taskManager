package br.com.taskmanager.taskmanager.service;

import br.com.taskmanager.taskmanager.model.TaskModel;
import br.com.taskmanager.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TaskServiceImpl implements TaskService{
    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void createTask(TaskModel task) {
        taskRepository.save(task);
    }

    @Override
    public void updateTask(Long id, TaskModel updatedTask) {
        TaskModel task = taskRepository.findById(id).orElseThrow();
        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setDate(updatedTask.getDate());
        taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<TaskModel> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public void setTaskCompleted(Long id) {
        TaskModel task = taskRepository.findById(id).orElseThrow();
        task.setCompleted(true);
        taskRepository.save(task);
    }

    @Override
    public void setTaskNotCompleted(Long id) {
        TaskModel task = taskRepository.findById(id).orElseThrow();
        task.setCompleted(false);
        taskRepository.save(task);
    }

    @Override
    public TaskModel getTaskById(Long taskId) {
        TaskModel task = taskRepository.findById(taskId).orElseThrow();
        return taskRepository.findById(task);
    }
}
