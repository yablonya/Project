package com.project.Project.controllers;

import com.project.Project.entity.TrainingProgramEntity;
import com.project.Project.services.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class HomeController {
    private final HomeService homeService;

    @GetMapping("/")
    public ArrayList<TrainingProgramEntity> getAllTrainingPrograms() {
        homeService.createAllPrograms();
        return homeService.getAllPrograms();
    }

    @GetMapping("/{programName}")
    public Optional<TrainingProgramEntity> getTrainingProgram(@PathVariable String programName) {
        return homeService.getProgram(programName);
    }
}
