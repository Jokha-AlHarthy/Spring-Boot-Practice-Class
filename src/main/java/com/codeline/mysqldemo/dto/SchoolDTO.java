package com.codeline.mysqldemo.dto;

import com.codeline.mysqldemo.entities.School;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder //used to create objects and set their values.
@NoArgsConstructor
@AllArgsConstructor
public class SchoolDTO {
    @PositiveOrZero
    private Long schoolId;
    @NotBlank(message = "You can't leave the school name to be null")
    @Size(min=3, max = 20, message = "School name has to be between 3 to 20 characters")
    private String schoolName;
    @NotBlank(message = "You can't leave the school location to be null")
    @Size(min=10, max = 50, message = "School location has to be between 10 to 50 characters")
    private String schoolLocation;

    public static SchoolDTO convertToDTO(School entity){
        /*SchoolDTO dto =  new SchoolDTO();
        dto.setSchoolId(entity.getId());
        dto.schoolName(entity.getName());
        dto.schoolLocation(entity.getLocation());
        without using the Builder
        */

        //with using the Builder
        SchoolDTO dto = SchoolDTO.builder()
                .schoolId(entity.getId())
                .schoolName(entity.getName())
                .schoolLocation(entity.getLocation())
                .build();
        return dto;
    }

    public static List<SchoolDTO> convertToDTO(List<School>entityList){
        List<SchoolDTO> dtos =  new ArrayList<>();
        for(School school : entityList){
            dtos.add(convertToDTO(school));
        }
        return dtos;
    }
}
