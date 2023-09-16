package com.project.Project.controllers;

import com.project.Project.entity.TrainingProgramEntity;
import com.project.Project.services.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {
    private final HomeService homeService;

    @GetMapping
    public ArrayList<TrainingProgramEntity> getAllTrainingPrograms() {
        homeService.createAllPrograms();
        return homeService.getAllPrograms();
    }

    @GetMapping("{name}")
    public Optional<TrainingProgramEntity> getTrainingProgram(@PathVariable String name) {
        return homeService.getProgram(name);
    }
}
