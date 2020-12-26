package com.practice.sensei.task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskGroup {
    private String name;
    private String description;
    private List<Task> tasks;
}
