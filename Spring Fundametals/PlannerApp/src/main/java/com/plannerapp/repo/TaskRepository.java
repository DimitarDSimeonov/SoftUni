package com.plannerapp.repo;

import com.plannerapp.model.entity.Task;
import com.plannerapp.model.view.TaskViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t WHERE user = null")
    List<Task> findAllAvailable();

    List<Task> findByUser_Id(Long id);

}
