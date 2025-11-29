package br.com.taskmanager.taskmanager.repository;

import br.com.taskmanager.taskmanager.model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, Long> {
    TaskModel findById(TaskModel task);
}
