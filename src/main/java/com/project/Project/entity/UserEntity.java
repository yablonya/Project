package com.project.Project.entity;

import lombok.Data;

import java.util.ArrayList;

@Data
public class UserEntity {
    private final String name;
    private final String surname;
    private final String email;
    private final String password;
    private ArrayList<ProgressRecordEntity> progress = new ArrayList<>();
    private ArrayList<String> notes = new ArrayList<>();

    public UserEntity(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }
}
