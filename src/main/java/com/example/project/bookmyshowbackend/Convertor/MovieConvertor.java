package com.example.project.bookmyshowbackend.Convertor;

import com.example.project.bookmyshowbackend.DTO.EntryDTO.MovieEntryDto;
import com.example.project.bookmyshowbackend.DTO.ResponseDTO.MovieResponseDto;
import com.example.project.bookmyshowbackend.Models.MovieEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MovieConvertor {
     public static MovieEntity convertDtoToEntity(MovieEntryDto movieEntryDto){
         return MovieEntity.builder().name(movieEntryDto.getName()).releaseDate(movieEntryDto.getReleaseDate()).build();
     }
     public static MovieResponseDto convertEntityToDto(MovieEntity movie){
         return MovieResponseDto.builder().id(movie.getId()).name(movie.getName()).releaseDate(movie.getReleaseDate()).build();
     }

}
