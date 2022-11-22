package com.example.project.bookmyshowbackend.Service;

import com.example.project.bookmyshowbackend.DTO.EntryDTO.ShowEntryDto;
import com.example.project.bookmyshowbackend.DTO.ResponseDTO.ShowResponseDto;

public interface ShowService {
    ShowResponseDto addShow(ShowEntryDto showEntryDto);
    ShowResponseDto getShow(int id);
}
