package com.tmaksimenko.task_hive.service;

import com.tmaksimenko.task_hive.model.Task;
import com.tmaksimenko.task_hive.model.User;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    Optional<Task> findById (Long id);

    List<Task> findByUser (User user);

    List<Task> findByUserId (Long userId);

    List<Task> findByUserName (String username);

    Task createTask (Task task);

    Task updateTask (Task task);

    Task deleteTask (Long id);

}
