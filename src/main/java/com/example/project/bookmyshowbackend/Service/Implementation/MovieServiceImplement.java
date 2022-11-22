package com.example.project.bookmyshowbackend.Service.Implementation;

import com.example.project.bookmyshowbackend.Convertor.MovieConvertor;
import com.example.project.bookmyshowbackend.DTO.EntryDTO.MovieEntryDto;
import com.example.project.bookmyshowbackend.DTO.ResponseDTO.MovieResponseDto;
import com.example.project.bookmyshowbackend.Models.MovieEntity;
import com.example.project.bookmyshowbackend.Repository.MovieRepository;
import com.example.project.bookmyshowbackend.Service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MovieServiceImplement implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public MovieResponseDto addMovie(MovieEntryDto movieEntryDto) {
        //if movie with same name already exists,
        MovieResponseDto movieResponseDto=null;
      if(movieRepository.existsByName(movieEntryDto.getName())){
          movieResponseDto.setName("This movie is already existing");
           return movieResponseDto;
      }


        log.info("Adding a movie "+movieEntryDto);
        MovieEntity movie= MovieConvertor.convertDtoToEntity(movieEntryDto);
        movieRepository.save(movie);
         movieResponseDto=MovieConvertor.convertEntityToDto(movie);
        return movieResponseDto;
    }

    @Override
    public MovieResponseDto getMovie(int id) {
        MovieEntity movie= movieRepository.findById(id).get();
        MovieResponseDto movieDto=MovieConvertor.convertEntityToDto(movie);
        return movieDto;
    }
}
