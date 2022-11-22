package com.example.project.bookmyshowbackend.DTO.ResponseDTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketResponseDto {
    int id;
    String allotedSeats;
    double amount;
}
