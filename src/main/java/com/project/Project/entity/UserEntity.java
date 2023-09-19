package com.project.Project.entity;

import lombok.Data;

import java.util.ArrayList;

@Data
public class UserEntity {
    private final String name;
    private final String surname;
    private final String email;
    private final String password;
    private int height;
    private int weight;
    private ArrayList<String[]> progress;
    private ArrayList<String> notes;

    public UserEntity(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }
}
