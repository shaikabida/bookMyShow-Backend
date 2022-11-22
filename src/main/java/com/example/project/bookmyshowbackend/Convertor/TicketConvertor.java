package com.example.project.bookmyshowbackend.Convertor;

import com.example.project.bookmyshowbackend.DTO.ResponseDTO.TicketResponseDto;
import com.example.project.bookmyshowbackend.DTO.TicketDto;
import com.example.project.bookmyshowbackend.Models.Ticket;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TicketConvertor {
    public static Ticket convertDtoToEntity(TicketDto ticketDto){
        return Ticket.builder().allotedSeats(ticketDto.getAllotedSeats()).amount(ticketDto.getAmount()).build();
    }
    public static TicketResponseDto convertEntityToDto(Ticket ticket){
        return TicketResponseDto.builder().id(ticket.getId()).allotedSeats(ticket.getAllotedSeats()).amount(ticket.getAmount()).build();
    }

}
