package com.collegeportal.user.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class User
{
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String fatherName;
    private String motherName;
    private LocalDate dateOfBirth;
}
