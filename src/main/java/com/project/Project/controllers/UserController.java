package com.project.Project.controllers;

import com.project.Project.entity.UserEntity;
import com.project.Project.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/register")
    public ResponseEntity registerUser(UserEntity user) {
        try {
            userService.createUser(user);
            return ResponseEntity.ok("Все класно :)");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Щось пішло не так :(");
        }
    }

    @GetMapping("/get-user-info")
    public UserEntity getUserInfo(String email, String password) {
        return userService.getUser(email, password);
    }

    @PostMapping("/delete-user")
    public ResponseEntity registerUser(String email, String password) {
        try {
            userService.deleteUser(email, password);
            return ResponseEntity.ok("Все класно :)");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Щось пішло не так :(");
        }
    }
}
