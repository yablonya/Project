package com.project.Project.repositories;

import com.project.Project.entity.TrainingProgramEntity;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
public class ProgramRepository {
    private ArrayList<TrainingProgramEntity> programs = new ArrayList<>();

    public Optional<TrainingProgramEntity> getTrainingProgram(String name) {
        return programs.stream()
                .filter(program -> Objects.equals(program.getName(), name))
                .findFirst();
    }

    public ArrayList<TrainingProgramEntity> getPrograms() {
        return programs;
    }

    public void addProgram(TrainingProgramEntity program) {
        programs.add(program);
    }
}
