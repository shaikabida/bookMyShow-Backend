package com.example.project.bookmyshowbackend.Service;

import com.example.project.bookmyshowbackend.DTO.EntryDTO.TheatreEntryDto;
import com.example.project.bookmyshowbackend.DTO.ResponseDTO.TheatreResponseDto;

public interface TheatreService {
    TheatreResponseDto addTheatre(TheatreEntryDto theatreEntryDto);
    TheatreResponseDto getTheatre(int id);
}
