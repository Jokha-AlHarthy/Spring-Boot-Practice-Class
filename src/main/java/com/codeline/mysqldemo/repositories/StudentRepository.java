package com.codeline.mysqldemo.repositories;

import com.codeline.mysqldemo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM Student s WHERE s.isActive=true")
    List<Student> getAllStudent();

    @Query("SELECT s FROM Student s WHERE s.isActive=true AND s.id=:abc")
    Student getById(@Param("abc") Long id);


}
