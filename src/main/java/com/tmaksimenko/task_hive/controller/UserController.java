package com.tmaksimenko.task_hive.controller;

import com.tmaksimenko.task_hive.model.User;
import com.tmaksimenko.task_hive.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser (@PathVariable Long id) {
        return ResponseEntity.of(userService.findUser(id));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers () {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping
    public ResponseEntity<User> createUser (@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PutMapping
    public ResponseEntity<User> updateUser (@RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser (@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }

}
