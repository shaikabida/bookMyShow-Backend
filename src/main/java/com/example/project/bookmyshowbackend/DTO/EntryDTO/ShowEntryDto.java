package com.example.project.bookmyshowbackend.DTO.EntryDTO;

import com.example.project.bookmyshowbackend.DTO.ResponseDTO.MovieResponseDto;
import com.example.project.bookmyshowbackend.DTO.ResponseDTO.TheatreResponseDto;
import com.sun.istack.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowEntryDto {
    @NotNull
    LocalDate showDate;
    @NotNull
    LocalTime showTime;

    @NotNull
    MovieResponseDto movieResponseDto;
    @NotNull
    TheatreResponseDto theatreResponseDto;
}
