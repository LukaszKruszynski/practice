package com.practice.sensei.config;

import com.practice.sensei.task.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RandomGeneratorTest {

    @Autowired
    RandomGenerator randomGenerator;

    @Test
    void shouldGenerateRandomTask() {
        //given & when
        Task randomTask = randomGenerator.getRandomTask();
        //then
        Assertions.assertNotNull(randomTask);
        Assertions.assertNotNull(randomTask.getId());
        Assertions.assertNotNull(randomTask.getName());
        Assertions.assertNotNull(randomTask.getDescription());
        Assertions.assertNotNull(randomTask.getBeginning());
        Assertions.assertNotNull(randomTask.getDeadLine());
        Assertions.assertNotNull(randomTask.isDone());
        Assertions.assertNotNull(randomTask.getPersonAssign());
        Assertions.assertNotNull(randomTask.getGroup());
    }


}