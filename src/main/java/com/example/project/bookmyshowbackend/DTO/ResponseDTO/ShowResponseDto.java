package com.example.project.bookmyshowbackend.DTO.ResponseDTO;

import com.example.project.bookmyshowbackend.DTO.ResponseDTO.MovieResponseDto;
import com.sun.istack.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowResponseDto {
    int id;
    LocalDate showDate;
    LocalTime showTime;


    MovieResponseDto movieResponseDto;
    TheatreResponseDto theatreResponseDto;
}
