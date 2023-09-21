package com.project.Project.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProgressRecordEntity {
    private Integer height;
    private Integer weight;
    private LocalDateTime creationDate;

    public ProgressRecordEntity(Integer height, Integer weight) {
        this.height = height;
        this.weight = weight;
        this.creationDate = LocalDateTime.now();
    }
}
