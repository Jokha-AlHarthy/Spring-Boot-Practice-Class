package com.codeline.mysqldemo.controllers;

import com.codeline.mysqldemo.dto.SchoolDTO;
import com.codeline.mysqldemo.entities.School;
import com.codeline.mysqldemo.repositories.SchoolRepository;
import com.codeline.mysqldemo.services.SchoolService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@CrossOrigin(origins = "*")
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
    //valid used to see the validation of the data
    @PostMapping("add")
    public Long addSchool(@Valid @RequestBody SchoolDTO dto){
        return schoolService.addSchool(dto.getSchoolName(), dto.getSchoolLocation());
    }

    //GetAll API
    @GetMapping("getAll")
    public List<SchoolDTO> getAllSchools(){
        List<SchoolDTO>schools = SchoolDTO.convertToDTO(schoolService.getAllSchools());
        return schools;
    }

    //Get By Id API
    @GetMapping("getById")
    public SchoolDTO getById(@RequestParam Long id){
        return SchoolDTO.convertToDTO(schoolService.getById(id));
    }

    //Update API
    //valid used to see the validation of the data
    @PutMapping("update")
    public SchoolDTO updateSchool(@Valid @RequestBody SchoolDTO dto){
        return SchoolDTO.convertToDTO(schoolService.updatedSchool(dto.getSchoolId(), dto.getSchoolName(), dto.getSchoolLocation()));
    }

    //Delete API
    @DeleteMapping("delete")
    public Boolean deleteSchoolById(@RequestParam Long id) {
        return schoolService.deleteById(id);
    }
}
