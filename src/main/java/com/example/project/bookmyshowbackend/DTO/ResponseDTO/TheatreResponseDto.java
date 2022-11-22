package com.example.project.bookmyshowbackend.DTO.ResponseDTO;

import com.example.project.bookmyshowbackend.DTO.ResponseDTO.ShowResponseDto;
import com.example.project.bookmyshowbackend.ENUM.TheatreType;
import com.sun.istack.NotNull;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TheatreResponseDto {
    @NotNull
    int id;
    String name;
    String address;
    String city;
    TheatreType type;
}
