package com.codeline.mysqldemo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity //used to convert attributes to be as table in mySQL
public class School {
    @Id //to make the Id attribute be unique
    @GeneratedValue(strategy = GenerationType.AUTO) //generate a unique Id by the code
    private Long id;

    private String name;
    private String location;
    private Boolean isActive;
    private Date createdDate;
    private Date updatedDate;
}
