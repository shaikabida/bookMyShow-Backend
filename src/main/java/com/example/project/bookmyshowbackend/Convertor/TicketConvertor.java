package com.example.project.bookmyshowbackend.Convertor;

import com.example.project.bookmyshowbackend.DTO.ResponseDTO.TicketResponseDto;
import com.example.project.bookmyshowbackend.DTO.TicketDto;
import com.example.project.bookmyshowbackend.Models.TicketEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TicketConvertor {
    public static TicketEntity convertDtoToEntity(TicketDto ticketDto){
        return TicketEntity.builder().allotedSeats(ticketDto.getAllotedSeats()).amount(ticketDto.getAmount()).build();
    }
    public static TicketResponseDto convertEntityToDto(TicketEntity ticket){
        return TicketResponseDto.builder().id(ticket.getId()).allotedSeats(ticket.getAllotedSeats()).amount(ticket.getAmount()).build();
    }

}
