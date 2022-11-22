package com.example.project.bookmyshowbackend.DTO.ResponseDTO;

import com.sun.istack.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieResponseDto {
    @NotNull
    int id;
    String name;
    LocalDate releaseDate;
    List<ShowResponseDto> showDtoList;
}
