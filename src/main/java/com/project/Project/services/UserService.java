package com.project.Project.services;

import com.project.Project.entity.ProgressRecordEntity;
import com.project.Project.entity.UserEntity;
import com.project.Project.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserEntity createUser(UserEntity userData) {
        if (!userRepository.findUser(userData.getEmail())) {
            UserEntity newUser = userRepository.addUser(userData);
            log.info("Saved new User {}:", newUser);
            return newUser;
        }
        return null;
    }

    public Optional<UserEntity> getUser(String email, String password) {
        return userRepository.getUser(email, password);
    }

    public UserEntity addProgressRecord(Integer height, Integer weight, String email, String password) {
        UserEntity user = getUser(email, password).orElse(null);
        if (user != null) { user.getProgress().add(new ProgressRecordEntity(height, weight)); }
        return user;
    }

    public UserEntity addNote(String note, String email, String password) {
        UserEntity user = getUser(email, password).orElse(null);
        if (user != null) { user.getNotes().add(note); }
        return user;
    }

    public void deleteUser(String email, String password) {
        userRepository.deleteUser(email, password);
        log.info("Deleted User with email {}:", email);
    }
}
