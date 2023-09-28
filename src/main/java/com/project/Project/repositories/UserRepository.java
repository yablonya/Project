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

    public Optional<UserEntity> getUser(String email, String password) {
        return users.stream()
                .filter(item -> item.getEmail().equals(email) && item.getPassword().equals(password))
                .findFirst();
    }

    public Boolean findUser(String email) {
        for (UserEntity user : users) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public UserEntity addUser(UserEntity user) {
        users.add(user);
        return user;
    }

    public void deleteUser(String email, String password) {
        users.remove(this.getUser(email, password).orElse(null));
    }
}
