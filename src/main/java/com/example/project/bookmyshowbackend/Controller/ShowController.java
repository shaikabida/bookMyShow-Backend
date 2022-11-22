package com.example.project.bookmyshowbackend.Controller;

import com.example.project.bookmyshowbackend.DTO.EntryDTO.ShowEntryDto;
import com.example.project.bookmyshowbackend.DTO.ResponseDTO.ShowResponseDto;
import com.example.project.bookmyshowbackend.DTO.ResponseDTO.UserResponseDto;
import com.example.project.bookmyshowbackend.Service.Implementation.ShowServiceImplement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("show")
public class ShowController {
    @Autowired
    ShowServiceImplement showServiceImplement;

    @PostMapping("/add")
    public ResponseEntity addShow(@RequestBody ShowEntryDto showEntryDto){
        ShowResponseDto showResponseDto=showServiceImplement.addShow(showEntryDto);
        log.info("Thw showResponseDto is ",showResponseDto);
        return new ResponseEntity("Added Show successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ShowResponseDto> getShow(@PathVariable(value="id")int id){
        ShowResponseDto showDto=showServiceImplement.getShow(id);
        return new ResponseEntity<>(showDto,HttpStatus.OK);
    }
}
