package com.example.project.bookmyshowbackend.Convertor;

import com.example.project.bookmyshowbackend.DTO.EntryDTO.TheatreEntryDto;
import com.example.project.bookmyshowbackend.DTO.ResponseDTO.TheatreResponseDto;
import com.example.project.bookmyshowbackend.Models.TheatreEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TheatreConvertor {
    public static TheatreEntity convertDtoToEntity(TheatreEntryDto theatreEntryDto){
        return TheatreEntity.builder().name(theatreEntryDto.getName()).address(theatreEntryDto.getAddress()).city(theatreEntryDto.getCity()).build();
    }
    public static TheatreResponseDto convertEntitytoDto(TheatreEntity theatre){
        return TheatreResponseDto.builder().id(theatre.getId()).name(theatre.getName())
                .address(theatre.getAddress()).city(theatre.getCity())
                .type(theatre.getType()).build();
    }
}
