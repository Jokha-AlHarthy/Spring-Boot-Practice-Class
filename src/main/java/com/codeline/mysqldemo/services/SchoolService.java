package com.codeline.mysqldemo.services;

import com.codeline.mysqldemo.entities.School;
import com.codeline.mysqldemo.repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

//the purpose of the service is to do business logic
@Service
public class SchoolService {
    /* @Autowired //dependency injunction
    SchoolRepository schoolRepository;
    and this the bad way to do the injunction*/

    SchoolRepository schoolRepository;
    @Autowired
    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    //ADD
    public Long addSchool(String name, String location){
        School school =  new School();
        school.setIsActive(true);
        school.setCreatedDate(new Date());
        school.setName(name);
        school.setLocation(location);
        school = schoolRepository.save(school); //used to save the data into the database
        return school.getId(); //it return the output
    }

    //GET ALL
    public List<School> getAllSchools(){
        return schoolRepository.getAllSchool();
    }

    //GET BY ID - to return one school
    public School getById(Long id){
        Optional <School> school =  schoolRepository.findById(id);
        //condition to check the optional function
        if(school.isPresent() && school.get().getIsActive()){
            return school.get();
        }
        return new School();
    }

    //Update
    public School updatedSchool(Long id, String updateName, String updateLocation){
        School schoolToUpdate = schoolRepository.getById(id);
        if(schoolToUpdate == null){
            return new School(); //this return an empty school
        }
        schoolToUpdate.setUpdatedDate(new Date());
        schoolToUpdate.setName(updateName);
        schoolToUpdate.setLocation(updateLocation);
        schoolToUpdate = schoolRepository.save(schoolToUpdate); //used to save the data into the database
        return schoolToUpdate;
    }

    //delete
    public Boolean deleteById(Long id) {
        School deleteSchool = schoolRepository.getById(id);
        if(deleteSchool == null){
            return false; //this return an empty school
        } else {
            deleteSchool.setIsActive(false);
            deleteSchool.setUpdatedDate(new Date());
            schoolRepository.save(deleteSchool);
            return true;
        }
    }

}
