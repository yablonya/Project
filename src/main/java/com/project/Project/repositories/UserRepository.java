package com.project.Project.repositories;

import com.project.Project.entity.UserEntity;

import java.util.ArrayList;
import java.util.Optional;

public class UserRepository {
    private final ArrayList<UserEntity> users = new ArrayList<>();

    public Optional<UserEntity> getUser(String email, String password) {
        return users.stream()
                .filter((item) -> (
                        item.getEmail().equals(email) && item.getPassword().equals(password)
                ))
                .findFirst();
    }

    public void addUser(UserEntity user) {
        users.add(user);
    }

    public void deleteUser(String email, String password) {
        users.remove(this.getUser(email, password).orElse(null));
    }
}
