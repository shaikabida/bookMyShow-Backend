package com.example.project.bookmyshowbackend.Convertor;

import com.example.project.bookmyshowbackend.DTO.EntryDTO.MovieEntryDto;
import com.example.project.bookmyshowbackend.DTO.ResponseDTO.MovieResponseDto;
import com.example.project.bookmyshowbackend.Models.Movie;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MovieConvertor {
     public static Movie convertDtoToEntity(MovieEntryDto movieEntryDto){
         return Movie.builder().name(movieEntryDto.getName()).releaseDate(movieEntryDto.getReleaseDate()).build();
     }
     public static MovieResponseDto convertEntityToDto(Movie movie){
         return MovieResponseDto.builder().id(movie.getId()).name(movie.getName()).releaseDate(movie.getReleaseDate()).build();
     }

}
