package com.practice.sensei.service;

import com.practice.sensei.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TaskService {

    private TaskServiceImpl taskServiceImpl;

    @Autowired
    public TaskService(TaskServiceImpl taskServiceImpl) {
        this.taskServiceImpl = taskServiceImpl;
    }

    public Map<Long, Task> findAll() {
        Map<Long, Task> map = new HashMap<>();
        List<Task> tasks = taskServiceImpl.findAll();
        tasks.stream().forEach(t -> map.put(t.getId(), t));
        return map;
    }

    public Map<Long, Task> findById(Long id) {
        Map<Long, Task> map = new HashMap<>();
        Optional<Task> byId = taskServiceImpl.findById(id);
        if (byId.isPresent()) {
            map.put(byId.get().getId(), byId.get());
        }
        return map;
    }

    public long count() {
        return findAll().size();
    }
}
