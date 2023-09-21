package com.project.Project.services;

import com.project.Project.entity.TrainingProgramEntity;
import com.project.Project.repositories.ProgramRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProgramService {
    private final ProgramRepository programRepository;

    public ArrayList<TrainingProgramEntity> getAllPrograms() {
        return programRepository.getPrograms();
    }

    public Optional<TrainingProgramEntity> getProgram(String name) {
        return programRepository.getTrainingProgram(name);
    }
}
