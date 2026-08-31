package com.codeline.mysqldemo.services;

import com.codeline.mysqldemo.entities.School;
import com.codeline.mysqldemo.repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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
}
