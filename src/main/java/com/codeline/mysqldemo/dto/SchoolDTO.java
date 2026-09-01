package com.codeline.mysqldemo.dto;

import com.codeline.mysqldemo.entities.School;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder //used to create objects and set their values.
public class SchoolDTO {
    private Long schoolId;
    private String schoolName;
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
