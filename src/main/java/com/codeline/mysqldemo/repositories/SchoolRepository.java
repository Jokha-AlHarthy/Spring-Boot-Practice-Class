package com.codeline.mysqldemo.repositories;

import com.codeline.mysqldemo.entities.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
    @Query("SELECT s FROM School s WHERE s.isActive=true")
    List<School> getAllSchool();

    //abc is a name of parameter
    @Query("SELECT s FROM School s WHERE s.isActive=true AND s.id=:abc")
    School getById(@Param("abc") Long id); //replacing the id into abc
}
