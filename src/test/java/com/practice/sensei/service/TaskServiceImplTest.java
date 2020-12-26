package com.practice.sensei.service;

import com.practice.sensei.task.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class TaskServiceImplTest {

    @Autowired
    TaskServiceImpl taskService;

    @Test
    void shouldFetchAllTasks() {
        //given & when
        List<Task> all = taskService.findAll();
        //then
        Assertions.assertFalse(all.isEmpty());
    }

    @Test
    void shouldFetchTaskById() {
        //given
        Task task = Task.builder()
                .id(10l)
                .build();
        taskService.save(task);
        //when
        Optional<Task> byId = taskService.findById(10l);
        //then
        Assertions.assertTrue(byId.isPresent());
        Assertions.assertEquals(10l,byId.get().getId());
    }

    @Test
    void shouldFetchEmptyOptional() {
        //given & when
        Optional<Task> byId = taskService.findById(Long.MAX_VALUE);
        //then
        Assertions.assertFalse(byId.isPresent());
    }

    @Test
    void shouldDeleteTask() {
        //given
        long count = taskService.count();
        Task task = Task.builder()
                .id(count + 1)
                .build();
        taskService.save(task);
        //when
        taskService.delete(task);
        //then
        Assertions.assertFalse(taskService.findById(count + 1).isPresent());
    }

    @Test
    void shouldDeleteTaskById() {
        //given
        long count = taskService.count();
        Task task = Task.builder()
                .id(count + 1)
                .build();
        taskService.save(task);
        //when
        taskService.deleteById(count + 1);
        //then
        Assertions.assertFalse(taskService.findById(count + 1).isPresent());
    }

    @Test
    void shouldSaveTask() {
        //given
        long count = taskService.count();
        Task task = Task.builder()
                .id(count + 1)
                .build();
        //when
        taskService.save(task);
        //then
        Assertions.assertTrue(taskService.findById(count + 1).isPresent());
    }
}