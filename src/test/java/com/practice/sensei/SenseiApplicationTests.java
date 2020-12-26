package com.practice.sensei;

import com.practice.sensei.config.Config;
import com.practice.sensei.service.TaskServiceImpl;
import com.practice.sensei.task.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@SpringBootTest
class SenseiApplicationTests {

    @Autowired
    TaskServiceImpl service;

    @Test
    void contextLoads() {
    }

    @Test
    void shouldFetchRandomString() {
        Task task = Task.builder()
                .name("sasa")
                .id(150l)
                .build();
        long count = service.count();
        service.save(task);
        long count2 = service.count();
        System.out.println(count);
        System.out.println(count2);
        service.delete(task);
        service.save(task);
        System.out.println(service.count());
        service.deleteById(150l);
        Optional<Task> byId = service.findById(150l);
        System.out.println(byId.get());

    }

}
