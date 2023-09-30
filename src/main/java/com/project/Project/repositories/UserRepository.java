package com.project.Project.repositories;

import com.project.Project.entity.UserEntity;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;
@Getter
@Repository
public class UserRepository {
    private final ArrayList<UserEntity> users = new ArrayList<>();

    public UserEntity addUser(UserEntity user) {
        users.add(user);
        return user;
    }

    public Optional<UserEntity> logUser(String email, String password) {
        return users.stream()
                .filter(item -> item.getEmail().equals(email) && item.getPassword().equals(password))
                .findFirst();
    }

    public UserEntity getUser(String email) {
        for (UserEntity user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public void deleteUser(String email, String password) {
        users.remove(this.logUser(email, password).orElse(null));
    }
}
