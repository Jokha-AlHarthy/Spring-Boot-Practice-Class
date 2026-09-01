package com.codeline.mysqldemo.controllers;

import com.codeline.mysqldemo.dto.StudentDTO;
import com.codeline.mysqldemo.entities.Student;
import com.codeline.mysqldemo.services.StudentService;
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
    public Long addStudent(@RequestParam String name, @RequestParam String major, @RequestParam String gender, @RequestParam String phoneNumber, @RequestParam String parentName, @RequestParam Long schoolId){
        return studentService.addStudent(name, major, gender, phoneNumber, parentName, schoolId);
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
    public StudentDTO updateStudent(@RequestParam Long id, @RequestParam String name, @RequestParam String major, @RequestParam String gender, @RequestParam String phoneNumber, @RequestParam String parentName){
        return StudentDTO.convertToDTO(studentService.updatedStudent(id, name, major, gender, phoneNumber, parentName));
    }

    //Delete API
    @DeleteMapping("delete")
    public Boolean deleteStudentById(@RequestParam Long id){
        return studentService.deleteById(id);
    }
}
