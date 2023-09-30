package com.project.Project.controllers;

import com.project.Project.entity.ProgressRecordEntity;
import com.project.Project.entity.UserEntity;
import com.project.Project.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    @PostMapping("/register")
    public ResponseEntity<UserEntity> registerUser(@RequestBody UserEntity user) {
        try {
            return ResponseEntity.ok(userService.createUser(user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/get-user-info")
    public ResponseEntity<UserEntity> getUserInfo(@RequestParam String email, @RequestParam String password) {
        return ResponseEntity.of(userService.getUser(email, password));
    }

    @PostMapping("/add-progress-record")
    public ResponseEntity<UserEntity> addProgressRecord(
            @RequestBody ProgressRecordEntity progressRecord,
            @RequestParam String email) {
        try {
            return ResponseEntity.ok(userService.addProgressRecord(progressRecord, email));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/delete-progress-record")
    public ResponseEntity<UserEntity> deleteProgressRecord(
            @RequestBody ProgressRecordEntity progressRecord,
            @RequestParam String email) {
        try {
            return ResponseEntity.ok(userService.deleteProgressRecord(progressRecord, email));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/add-note")
    public ResponseEntity<UserEntity> addNote(
            @RequestParam String note,
            @RequestParam String email) {
        try {
            return ResponseEntity.ok(userService.addNote(note, email));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/delete-note")
    public ResponseEntity<UserEntity> deleteNote(
            @RequestParam String note,
            @RequestParam String email) {
        try {
            return ResponseEntity.ok(userService.deleteNote(note, email));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/delete-user")
    public ResponseEntity<Void> deleteUser(@RequestParam String email,@RequestParam String password) {
        userService.deleteUser(email, password);
        return ResponseEntity.noContent().build();
    }
}
