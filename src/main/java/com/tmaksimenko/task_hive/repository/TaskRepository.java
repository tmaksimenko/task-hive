package com.tmaksimenko.task_hive.repository;

import com.tmaksimenko.task_hive.model.Task;
import com.tmaksimenko.task_hive.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository <Task, Long> {

    List<Task> findByUser (User user);

}
