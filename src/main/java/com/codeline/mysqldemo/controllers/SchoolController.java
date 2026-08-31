package com.codeline.mysqldemo.controllers;

import com.codeline.mysqldemo.repositories.SchoolRepository;
import com.codeline.mysqldemo.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("school")
public class SchoolController {

    //dependency injunction
    SchoolService schoolService;
    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    //Add API
    @PostMapping("add")
    public Long addSchool(@RequestParam String schoolName, @RequestParam String location){
        return schoolService.addSchool(schoolName, location);
    }



}
