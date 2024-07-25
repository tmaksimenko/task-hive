package com.tmaksimenko.task_hive.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    Long id;

    String username;

    String password;

    @CreatedDate
    Timestamp createTime;

    @OneToMany(mappedBy = "user")
    List<Task> tasks;

}
