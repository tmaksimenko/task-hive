package com.tmaksimenko.task_hive.repository;

import com.tmaksimenko.task_hive.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository <Task, Long> {
}
