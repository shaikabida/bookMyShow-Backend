package com.example.project.bookmyshowbackend.DTO;

import com.example.project.bookmyshowbackend.DTO.ResponseDTO.ShowResponseDto;
import com.example.project.bookmyshowbackend.DTO.ResponseDTO.UserResponseDto;
import com.sun.istack.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketDto {
    int id;
    String allotedSeats;
    double amount;

    @NotNull
    UserResponseDto userDto;

    ShowResponseDto showDto;
}

