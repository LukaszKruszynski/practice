package com.practice.sensei.service;

import com.practice.sensei.config.PrepareConfig;
import com.practice.sensei.config.RandomGenerator;
import com.practice.sensei.repository.TaskRepo;
import com.practice.sensei.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskRepo {

    private PrepareConfig prepareConfig;
    private List<Task> tasks;

    @Autowired
    public TaskServiceImpl(PrepareConfig prepareConfig) {
        this.tasks = new ArrayList<>();
        this.prepareConfig = prepareConfig;
    }

    @EventListener(ApplicationReadyEvent.class)
    private void fetchTasks() {
        this.tasks = prepareConfig.prepareTasks(RandomGenerator.random().nextInt(400) + 101);
    }

    @Override
    public List<Task> findAll() {
        return tasks;
    }

    @Override
    public Optional<Task> findById(Long id) {
        return tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findAny();
    }

    @Override
    public long count() {
        return tasks.size();
    }

    @Override
    public void delete(Task task) {
        if (tasks.contains(task)) {
            tasks.remove(task);
        }
    }

    @Override
    public void deleteById(Long id) {
        Optional<Task> task = tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findAny();
        if (task.isPresent()) {
            tasks.remove(task.get());
        }
    }

    @Override
    public void save(Task task) {
        if (task.getId() != null) {
            List<Task> list = tasks.stream()
                    .filter(t -> t.getId().equals(task.getId()))
                    .collect(Collectors.toList());
            if (list.size() == 0) {
                tasks.add(task);
            }
        } else {
            Task maxIdTask = tasks.stream().max(Comparator.comparing(Task::getId)).get();
            Long maxId = maxIdTask.getId();
            task.setId(maxId++);
            tasks.add(task);
        }
    }
}
