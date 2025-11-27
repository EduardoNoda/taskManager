package br.com.taskmanager.taskmanager.repository;

import br.com.taskmanager.taskmanager.model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, Long> {
    List<TaskModel> findByOwnerIdOrderByDueDateDesc(Long ownerId);
}
