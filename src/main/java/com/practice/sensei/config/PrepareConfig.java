package com.practice.sensei.config;

import com.practice.sensei.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PrepareConfig {
    private static RandomGenerator randomGenerator;
    private List<Task> tasks;

    @Autowired
    public PrepareConfig(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public static List<Task> prepareTasks(int quantityOfTasks) {
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < quantityOfTasks; i++) {
            tasks.add(randomGenerator.getRandomTask());
        }
        return tasks;
    }
}
