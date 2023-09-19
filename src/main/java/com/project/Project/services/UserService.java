package com.project.Project.services;

import com.project.Project.entity.UserEntity;
import com.project.Project.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private UserRepository userRepository = new UserRepository();

    public void createUser(UserEntity user) {
        userRepository.addUser(user);
    }

    public UserEntity getUser(String email, String password) {
        return userRepository.getUser(email, password).orElseThrow();
    }

    public void deleteUser(String email, String password) {
        userRepository.deleteUser(email, password);
    }
}
