package com.tmaksimenko.task_hive.service;

import com.tmaksimenko.task_hive.model.User;
import com.tmaksimenko.task_hive.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser (User user) {
        return userRepository.save(user);
    }



}
