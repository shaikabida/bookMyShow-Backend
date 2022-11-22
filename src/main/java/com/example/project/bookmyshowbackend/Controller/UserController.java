package com.example.project.bookmyshowbackend.Controller;

import com.example.project.bookmyshowbackend.DTO.EntryDTO.UserEntryDto;
import com.example.project.bookmyshowbackend.DTO.ResponseDTO.UserResponseDto;
import com.example.project.bookmyshowbackend.Service.Implementation.UserServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserServiceImplement userServiceImplement;

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody UserEntryDto userDto){
        userServiceImplement.addUser(userDto);
        return new ResponseEntity("Added user successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable(value="id")int id){
        UserResponseDto userDto=userServiceImplement.getUser(id);
        return new ResponseEntity<>(userDto,HttpStatus.OK);
    }


}
