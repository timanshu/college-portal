package com.collegeportal.course.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Course
{
    @Id
    private String id;
    private String courseName;
    private int durationInYrs;
    private long fee;
}
