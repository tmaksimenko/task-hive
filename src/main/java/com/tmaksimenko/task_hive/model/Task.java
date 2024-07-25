package com.tmaksimenko.task_hive.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Task {

    @Id
    long id;

    @ManyToOne
    User user;

    String title;

    String description;

    Timestamp dueDate;

    Boolean completed;

    @CreatedDate
    Timestamp createTime;

}
