package com.example.project.bookmyshowbackend.DTO.ResponseDTO;


import com.example.project.bookmyshowbackend.DTO.TicketDto;
import com.sun.istack.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDto {
    int id;
    String name;
    String mobileNumber;

    List<TicketDto> tickets;
}
