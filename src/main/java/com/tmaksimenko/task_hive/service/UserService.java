package com.tmaksimenko.task_hive.service;

import com.tmaksimenko.task_hive.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findUser (Long id);

    List<User> findAll ();

    User createUser (User user);

    User updateUser (User user);

    User deleteUser (Long id);

}
