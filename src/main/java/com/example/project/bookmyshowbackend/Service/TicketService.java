package com.example.project.bookmyshowbackend.Service;

import com.example.project.bookmyshowbackend.DTO.BookTicketRequestDto;
import com.example.project.bookmyshowbackend.DTO.ResponseDTO.TicketResponseDto;
import com.example.project.bookmyshowbackend.DTO.TicketDto;

public interface TicketService {
    TicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto);
    TicketResponseDto getTicket(int id);
}
