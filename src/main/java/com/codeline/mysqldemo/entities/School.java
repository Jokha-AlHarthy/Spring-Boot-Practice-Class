package com.codeline.mysqldemo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity //used to convert attributes to be as table in mySQL
public class School {
    @Id //to make the Id attribute be unique
    @GeneratedValue(strategy = GenerationType.AUTO) //generate a unique Id by the code
    private Long id;
    private String name;
    private String location;

    @OneToMany(cascade = CascadeType.ALL) //One shcool can have many students and we always need to use casecade
    List<Student> students;//relationship between school and student

    private Boolean isActive;
    private Date createdDate;
    private Date updatedDate;
}
