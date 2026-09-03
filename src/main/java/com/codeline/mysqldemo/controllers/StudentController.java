package com.codeline.mysqldemo.controllers;

import com.codeline.mysqldemo.dto.StudentDTO;
import com.codeline.mysqldemo.entities.Student;
import com.codeline.mysqldemo.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //Add API
    @PostMapping("add")
    public Long addStudent(@Valid @RequestBody StudentDTO dto){
        return studentService.addStudent(dto.getStudentName(), dto.getMajor() , dto.getGender(), dto.getPhoneNumber(), dto.getParentName(), dto.getSchoolId());
    }

    //GetAll API
    @GetMapping("getAll")
    public List<StudentDTO> getAllStudents(){
        List<StudentDTO>students =  StudentDTO.convertToDTO(studentService.getAllStudents());
        return students;
    }

    //Get By ID API
    @GetMapping("getById")
    public StudentDTO getById(@RequestParam Long id){
       return StudentDTO.convertToDTO(studentService.getById(id));
    }

    //Update API
    @PutMapping("update")
    public StudentDTO updateStudent(@Valid @RequestBody StudentDTO dto){
        return StudentDTO.convertToDTO(studentService.updatedStudent(dto.getStudentId(), dto.getStudentName(), dto.getMajor(), dto.getGender(), dto.getPhoneNumber(), dto.getParentName()));
    }

    //Delete API
    @DeleteMapping("delete")
    public Boolean deleteStudentById(@RequestParam Long id){
        return studentService.deleteById(id);
    }
}
