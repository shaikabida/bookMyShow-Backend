package com.example.project.bookmyshowbackend.Service;

import com.example.project.bookmyshowbackend.DTO.EntryDTO.MovieEntryDto;
import com.example.project.bookmyshowbackend.DTO.ResponseDTO.MovieResponseDto;

public interface MovieService {

    MovieResponseDto addMovie(MovieEntryDto movieEntryDto);

    MovieResponseDto getMovie(int id);
}
