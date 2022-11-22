package com.example.project.bookmyshowbackend.Service;

import com.example.project.bookmyshowbackend.DTO.EntryDTO.UserEntryDto;
import com.example.project.bookmyshowbackend.DTO.ResponseDTO.UserResponseDto;


public interface UserService {
    UserResponseDto addUser(UserEntryDto userEntryDto);
    UserResponseDto getUser(int id);

}
