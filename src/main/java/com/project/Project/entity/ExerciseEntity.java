package com.project.Project.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ExerciseEntity {
    private final String name;
    private final String repetitions;

}
