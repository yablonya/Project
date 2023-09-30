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
        if (userRepository.getUser(userData.getEmail()) == null) {
            UserEntity newUser = userRepository.addUser(userData);
            log.info("Saved new User {}:", newUser);
            return newUser;
        }
        return null;
    }

    public Optional<UserEntity> getUser(String email, String password) {
        return userRepository.logUser(email, password);
    }

    public UserEntity addProgressRecord(ProgressRecordEntity progressRecord, String email) {
        UserEntity user = userRepository.getUser(email);
        if (user != null) { user.getProgress().add(progressRecord); }
        return user;
    }

    public UserEntity deleteProgressRecord(ProgressRecordEntity progressRecord, String email) {
        UserEntity user = userRepository.getUser(email);
        if (user != null) { user.getProgress().remove(progressRecord); }
        return user;
    }

    public UserEntity addNote(String note, String email) {
        UserEntity user = userRepository.getUser(email);
        if (user != null) { user.getNotes().add(note); }
        return user;
    }

    public UserEntity deleteNote(String note, String email) {
        UserEntity user = userRepository.getUser(email);
        if (user != null) { user.getNotes().remove(note); }
        return user;
    }

    public void deleteUser(String email, String password) {
        userRepository.deleteUser(email, password);
        log.info("Deleted User with email {}:", email);
    }
}
