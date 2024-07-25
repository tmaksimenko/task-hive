package com.tmaksimenko.task_hive.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String username;

    String password;

    @CreationTimestamp
    Timestamp createTime;

    @OneToMany(mappedBy = "user")
    List<Task> tasks;

}
