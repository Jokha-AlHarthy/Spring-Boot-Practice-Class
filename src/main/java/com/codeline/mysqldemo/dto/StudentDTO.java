package com.codeline.mysqldemo.dto;

import com.codeline.mysqldemo.entities.School;
import com.codeline.mysqldemo.entities.Student;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

//Data transfer object
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    @PositiveOrZero(message = "The provided student identifier must be a valid, positive numeric value")
    private Long studentId;

    @NotBlank(message = "Please enter the student's full legal name")
    @Size(min = 3, max = 20, message = "The name field requires a length between 3 and 20 characters")
    private String studentName;

    @NotBlank(message = "Gender selection is required to proceed with registration")
    @Size(min = 1, max = 10, message = "Gender specification must not exceed 10 characters")
    private String gender;

    @NotBlank(message = "A primary contact number must be supplied")
    @Size(min = 7, max = 15, message = "Please enter a valid telephone number between 7 and 15 digits")
    private String phoneNumber;

    @NotBlank(message = "Guardian or parental contact name missing")
    @Size(min = 7, max = 15, message = "Parent or guardian name must be within 7 to 15 characters")
    private String parentName;

    @NotBlank(message = "You must specify the student's academic major")
    @Size(min = 2, max = 15, message = "The designated major must contain between 2 and 15 characters")
    private String major;

    private Long schoolId;

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
                .major(entity.getMajor())
                .phoneNumber(entity.getPhoneNumber())
                .parentName(entity.getParentName())
                .studentId(entity.getId())
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
