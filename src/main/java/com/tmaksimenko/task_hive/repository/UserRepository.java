package com.tmaksimenko.task_hive.repository;

import com.tmaksimenko.task_hive.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
