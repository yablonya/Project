package com.project.Project.entity;

import lombok.Data;

import java.util.ArrayList;

@Data
public class UserEntity {
    static long counter = 0;
    private final long id;
    private final String name;
    private final String surname;
    private final int password;
    private int height;
    private int weight;
    private ArrayList<String[]> progress;
    private ArrayList<String> notes;

    public UserEntity(String name, String surname, int password) {
        this.id = counter++;
        this.name = name;
        this.surname = surname;
        this.password = password;
    }
}
