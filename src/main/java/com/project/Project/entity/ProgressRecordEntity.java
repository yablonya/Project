package com.project.Project.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class ProgressRecordEntity {
    private String height;
    private String weight;
    private String creationDate;
}
