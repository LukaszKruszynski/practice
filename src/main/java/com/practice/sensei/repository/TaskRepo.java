package com.practice.sensei.repository;

import com.practice.sensei.task.Task;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public interface TaskRepo {
    List<Task> findAll();
    Optional<Task> findById(Long id);
    long count();
    void delete(Task task);
    void deleteById(Long id);
    void save(Task task);
}
