package com.project.Project.repositories;

import com.project.Project.entity.TrainingProgramEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@Getter
@Repository
@RequiredArgsConstructor
public class ProgramRepository {
    private final ArrayList<TrainingProgramEntity> programs = new ArrayList<>();

    public Optional<TrainingProgramEntity> getTrainingProgram(String name) {
        return programs.stream()
                .filter(program -> Objects.equals(program.getName(), name))
                .findFirst();
    }

    public void addProgram(TrainingProgramEntity program) {
        programs.add(program);
    }
}
