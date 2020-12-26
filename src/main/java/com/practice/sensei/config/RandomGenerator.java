package com.practice.sensei.config;

import com.practice.sensei.task.Task;
import com.practice.sensei.task.TaskGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class RandomGenerator {

    private static Random random;
    private Long id;

    @Autowired
    public RandomGenerator(Random random) {
        this.random = random;
        this.id = 1l;
    }

    public static LocalDate getRandomDate() {
        int randomYear = (10) + 2020;
        int randomMonth = random.nextInt(12) + 1;
        int randomDay = random.nextInt(31) + 1;
        List<Integer> monthsWith30Days = new ArrayList<>();
        monthsWith30Days.add(2);
        monthsWith30Days.add(4);
        monthsWith30Days.add(6);
        monthsWith30Days.add(9);
        monthsWith30Days.add(11);

        if (monthsWith30Days.contains(randomMonth) & randomDay == 31) {
            randomDay = random.nextInt(30) + 1;
        }

        if (randomMonth == 2 & randomDay >= 30) {
            randomDay = random.nextInt(28) + 1;
        }

        if (randomMonth == 2 & randomDay == 29 & randomYear % 4 != 0) {
            randomDay = random.nextInt(28) + 1;
        }

        LocalDate date = LocalDate.of(randomYear, randomMonth, randomDay);
        return date;
    }

    public static String getRandomString() {
        String randomString = "";
        for (int i = 0; i < random.nextInt(20) + 1; i++) {
            String charLower = "abcdefghijklmnopqrstuvwxyz";
            char ch = charLower.charAt(random.nextInt(charLower.length() - 1));

            if (random.nextBoolean()) {
                char upperCh = Character.toUpperCase(ch);
                ch = upperCh;
            }

            if (random.nextBoolean()) {
                randomString += String.valueOf(ch) + random.nextInt(10);
            } else {
                randomString += String.valueOf(ch);
            }

            if (randomString.length() == 20) break;
        }
        return randomString;
    }

    public Task getRandomTask() {
        Task task = Task.builder()
                .id(this.id)
                .beginning(LocalDate.now())
                .deadLine(getRandomDate())
                .description(getRandomString())
                .group(TaskGroup.builder()
                        .name(getRandomString())
                        .description(getRandomString())
                        .build())
                .isDone(random.nextBoolean())
                .name(getRandomString())
                .personAssign(getRandomString())
                .build();
        id++;
        return task;
    }

    @Bean
    public static Random random() {
        Random random = new Random();
        return random;
    }
}