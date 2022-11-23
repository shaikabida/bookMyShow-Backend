package com.example.project.bookmyshowbackend.Controller;

import com.example.project.bookmyshowbackend.DTO.BookTicketRequestDto;
import com.example.project.bookmyshowbackend.DTO.ResponseDTO.TicketResponseDto;
import com.example.project.bookmyshowbackend.Service.Implementation.TicketServiceImplement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;

@Slf4j
@RestController
@RequestMapping("ticket")
public class TicketController {
    @Autowired
    TicketServiceImplement ticketServiceImplement;

    @PostMapping("/add")
    public ResponseEntity<TicketResponseDto> addTicket(@RequestBody()BookTicketRequestDto bookTicketRequestDto){
        TicketResponseDto ticketResponseDto=ticketServiceImplement.bookTicket(bookTicketRequestDto);
        return new ResponseEntity<>(ticketResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<TicketResponseDto> getTicketById(@PathVariable(value="id")int id){
        TicketResponseDto ticketResponseDto=ticketServiceImplement.getTicket(id);
        return new ResponseEntity<>(ticketResponseDto,HttpStatus.OK);
    }
}
