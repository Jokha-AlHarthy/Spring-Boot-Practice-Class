package com.codeline.mysqldemo.dto;

import com.codeline.mysqldemo.entities.School;
import com.codeline.mysqldemo.entities.Student;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

//Data transfer object
@Getter
@Setter
@Builder
public class StudentDTO {
    private Long studentId;
    private String studentName;
    private String gender;

    public static StudentDTO convertToDTO(Student entity){
        /*SchoolDTO dto =  new StudentDTO();
        dto.studentId(entity.getId());
        dto.studentName(entity.getName());
        dto.gender(entity.getGender());
        without using the Builder
        */

        //with using the Builder
        StudentDTO dto = StudentDTO.builder()
                .studentId(entity.getId())
                .studentName(entity.getName())
                .gender(entity.getGender())
                .build();
        return dto;
    }

    public static List<StudentDTO> convertToDTO(List<Student>entityList){
        List<StudentDTO> dtos =  new ArrayList<>();
        for(Student student : entityList){
            dtos.add(convertToDTO(student));
        }
        return dtos;
    }
}
