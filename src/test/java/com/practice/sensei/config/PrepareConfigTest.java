package com.practice.sensei.config;

import com.practice.sensei.task.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
class PrepareConfigTest {

    @Test
    void shouldGenerateRandomTask() {
        //given & when
        List<Task> tasks = PrepareConfig.prepareTasks(3);
        //then
        Assertions.assertEquals(3,tasks.size());
    }
}