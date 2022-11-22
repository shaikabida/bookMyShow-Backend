package com.example.project.bookmyshowbackend.Controller;


import com.example.project.bookmyshowbackend.DTO.EntryDTO.TheatreEntryDto;
import com.example.project.bookmyshowbackend.DTO.ResponseDTO.TheatreResponseDto;
import com.example.project.bookmyshowbackend.DTO.ResponseDTO.UserResponseDto;
import com.example.project.bookmyshowbackend.Service.Implementation.TheatreServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("theatre")
public class TheatreController {
    @Autowired
    TheatreServiceImplement theatreServiceImplement;

    @PostMapping("/add")
    public ResponseEntity addTheatre(@RequestBody() TheatreEntryDto theatreEntryDto){
        theatreServiceImplement.addTheatre(theatreEntryDto);
        return new ResponseEntity("Added theatre successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<TheatreResponseDto> getTheatre(@PathVariable(value="id")int id){
        TheatreResponseDto theatreDto=theatreServiceImplement.getTheatre(id);
        return new ResponseEntity<>(theatreDto,HttpStatus.OK);
    }
}
