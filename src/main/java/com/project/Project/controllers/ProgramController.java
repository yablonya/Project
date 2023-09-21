package com.project.Project.controllers;

import com.project.Project.entity.TrainingProgramEntity;
import com.project.Project.services.ProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/programs")
public class ProgramController {
    private final ProgramService programService;

    @GetMapping
    public ResponseEntity<ArrayList<TrainingProgramEntity>> getAllTrainingPrograms() {
        return ResponseEntity.ok(programService.getAllPrograms());
    }

    @GetMapping("/{program-name}")
    public ResponseEntity<TrainingProgramEntity> getTrainingProgram(
            @PathVariable(name = "program-name") String programName
    ) {
        return ResponseEntity.of(programService.getProgram(programName));
    }
}
