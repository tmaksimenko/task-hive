package com.tmaksimenko.task_hive.controller;

import com.tmaksimenko.task_hive.model.Task;
import com.tmaksimenko.task_hive.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/task/{id}")
    public ResponseEntity<Task> getTask (@PathVariable Long id) {
        return ResponseEntity.of(taskService.findById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Task>> getTasks (@PathVariable Long userId) {
        return ResponseEntity.ok(taskService.findByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<Task> createTask (Task task) {
        return ResponseEntity.ok(taskService.createTask(task));
    }

    @PutMapping
    public ResponseEntity<Task> updateTask (Task task) {
        return ResponseEntity.ok(taskService.updateTask(task));
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<Task> deleteTask (@PathVariable Long id) {
        return ResponseEntity.ok(taskService.deleteTask(id));
    }

}
