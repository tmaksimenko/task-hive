package com.tmaksimenko.task_hive.service;

import com.tmaksimenko.task_hive.model.Task;
import com.tmaksimenko.task_hive.model.User;
import com.tmaksimenko.task_hive.repository.TaskRepository;
import com.tmaksimenko.task_hive.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class TaskServiceImplementation implements TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> findByUser(User user) {
        return taskRepository.findByUser(user);
    }

    @Override
    public List<Task> findByUserId(Long userId) {
        return taskRepository.findByUser(userRepository.findById(userId)
                .orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public List<Task> findByUserName(String username) {
        return taskRepository.findByUser(userRepository.findByUsername(username)
                .orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task deleteTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        Hibernate.initialize(task);
        taskRepository.deleteById(id);
        return task;
    }

}
