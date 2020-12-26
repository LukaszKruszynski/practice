package com.practice.sensei.task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    private Long id;
    private String name;
    private String description;
    private LocalDate beginning;
    private LocalDate deadLine;
    private boolean isDone;
    private String personAssign;
    private TaskGroup group;
}
