package com.project.Project.entity;

import java.util.ArrayList;

public class UserEntity {
    public String name;
    public String surname;
    public int password;
    public int height;
    public int weight;
    public TrainingProgram program;
    public ArrayList<String[]> progress;
    public ArrayList<String> notes;

    public UserEntity(String name, String surname, int password) {
        this.name = name;
        this.surname = surname;
        this.password = password;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public TrainingProgram getProgram() {
        return program;
    }

    public void setProgram(TrainingProgram program) {
        this.program = program;
    }

    public ArrayList<String[]> getProgress() {
        return progress;
    }

    public void setProgress(ArrayList<String[]> progress) {
        this.progress = progress;
    }

    public ArrayList<String> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<String> notes) {
        this.notes = notes;
    }
}
