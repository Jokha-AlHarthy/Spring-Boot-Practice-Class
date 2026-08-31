package com.codeline.mysqldemo.controllers;

import com.codeline.mysqldemo.entities.School;
import com.codeline.mysqldemo.repositories.SchoolRepository;
import com.codeline.mysqldemo.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //GetAll API
    @GetMapping("getAll")
    public List<School> getAllSchools(){
        return schoolService.getAllSchools();
    }

    //Get By Id API
    @GetMapping("getById")
    public School getById(@RequestParam Long id){
        return schoolService.getById(id);
    }

    //Update API
    @PutMapping("update")
    public School updateSchool(@RequestParam Long id, @RequestParam String updateName, @RequestParam String updateLocation){
        return schoolService.updatedSchool(id, updateName, updateLocation);
    }

    //Delete API
    @DeleteMapping("deleteById")
    public Boolean deleteSchoolById(@RequestParam Long id) {
        return schoolService.deleteById(id);
    }



}
