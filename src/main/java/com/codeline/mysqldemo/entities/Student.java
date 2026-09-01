package com.codeline.mysqldemo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String major;
    private String gender;
    private String phoneNumber;
    private String parentName;

    /*@ManyToOne //many students can have on school
    private School school; //relationship between school and student
    */

    private Boolean isActive;
    private Date createdDate;
    private Date updatedDate;


}
