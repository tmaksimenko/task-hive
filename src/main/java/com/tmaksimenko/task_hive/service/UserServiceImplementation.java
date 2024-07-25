package com.tmaksimenko.task_hive.service;

import com.tmaksimenko.task_hive.model.User;
import com.tmaksimenko.task_hive.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    @Override
    public Optional<User> findUser(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User createUser (User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
        user = emancipateUser(user);
        userRepository.deleteById(id);
        return user;
    }

    /**
     * This method exists in order to detach the user from the persistence context in
     * preparation for a delete operation that typically causes the lazily loaded
     * user to have no data
     * @param user is any User
     * @return user, a value copy of the original
     */
    private User emancipateUser (User user) {
        return User.builder()
                .id(user.getId())
                .username(user.getUsername())
                .createTime(user.getCreateTime())
                .password(user.getPassword())
                .tasks(new ArrayList<>(user.getTasks()))
                .build();
    }
}
