package com.project.Project.repositories;

import com.project.Project.entity.UserEntity;

import java.util.ArrayList;
import java.util.Optional;

public class UserRepository {
    private ArrayList<UserEntity> users;

    public Optional<UserEntity> getUser(long id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }

    public void addUser( UserEntity user ) {
        users.add(user);
    }

    public void deleteUser( UserEntity user ) {
        users.removeIf((item) -> item.getId() == user.getId());
    }
}
