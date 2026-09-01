package com.codeline.mysqldemo.services;

import com.codeline.mysqldemo.entities.School;
import com.codeline.mysqldemo.entities.Student;
import com.codeline.mysqldemo.repositories.SchoolRepository;
import com.codeline.mysqldemo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    SchoolService schoolService;
    StudentRepository studentRepository;
    SchoolRepository schoolRepository;

    @Autowired
    public StudentService(SchoolService schoolService, StudentRepository studentRepository, SchoolRepository schoolRepository) {
        this.schoolService = schoolService;
        this.studentRepository = studentRepository;
        this.schoolRepository = schoolRepository;
    }

    //Add
    public Long addStudent(String name, String major, String gender, String phoneNumber, String parentName, Long schoolId){
        School school = schoolService.getById(schoolId);
        if(school==null || school.getIsActive() == false){
            return -1l;
        }
        Student student =  new Student();
        student.setName(name);
        student.setMajor(major);
        student.setPhoneNumber(phoneNumber);
        student.setGender(gender);
        student.setParentName(parentName);
        student.setCreatedDate(new Date());
        student.setIsActive(true);
        Student savedStudent = studentRepository.save(student);

        //saving record to the database
        List<Student>studentList = school.getStudents();
        studentList.add(savedStudent);
        school.setStudents(studentList);
        schoolRepository.save(school);

        //giving the data back that is already saved 
        return savedStudent.getId();
    }

    //Get All
    public List<Student> getAllStudents(){
        return studentRepository.getAllStudent();
    }

    //Get By Id
    public Student getById(Long id){
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent() && student.get().getIsActive()){
            return student.get();
        }
        return new Student();
    }

    //Update
    public Student updatedStudent(Long id, String name, String major, String gender, String phoneNumber, String parentName){
        Student studentToUpdate = studentRepository.getById(id);
        if(studentToUpdate == null){
            return new Student();
        }
        studentToUpdate.setName(name);
        studentToUpdate.setMajor(major);
        studentToUpdate.setGender(gender);
        studentToUpdate.setPhoneNumber(phoneNumber);
        studentToUpdate.setParentName(parentName);
        studentToUpdate =  studentRepository.save(studentToUpdate);
        return studentToUpdate;
    }

    //Delete
    public Boolean deleteById(Long id){
        Student deleteStudent = studentRepository.getById(id);
        if(deleteStudent == null){
            return false;
        }else{
            deleteStudent.setIsActive(false);
            deleteStudent.setUpdatedDate(new Date());
            studentRepository.save(deleteStudent);
            return true;
        }
    }
}

