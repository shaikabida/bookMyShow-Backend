package com.example.project.bookmyshowbackend.Service.Implementation;

import com.example.project.bookmyshowbackend.Convertor.ShowConvertor;
import com.example.project.bookmyshowbackend.DTO.EntryDTO.ShowEntryDto;
import com.example.project.bookmyshowbackend.DTO.ResponseDTO.ShowResponseDto;
import com.example.project.bookmyshowbackend.Models.*;
import com.example.project.bookmyshowbackend.Repository.MovieRepository;
import com.example.project.bookmyshowbackend.Repository.ShowRepository;
import com.example.project.bookmyshowbackend.Repository.ShowSeatsRepository;
import com.example.project.bookmyshowbackend.Repository.TheatreRepository;
import com.example.project.bookmyshowbackend.Service.ShowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ShowServiceImplement implements ShowService {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    ShowSeatsRepository showSeatsRepository;

    @Autowired
    ShowRepository showRepository;


    @Override
    public ShowResponseDto addShow(ShowEntryDto showEntryDto) {
        ShowEntity show= ShowConvertor.convertDtoToEntity(showEntryDto);

        MovieEntity movie = movieRepository.findById(showEntryDto.getMovieResponseDto().getId()).get();
        TheatreEntity theatre=theatreRepository.findById(showEntryDto.getTheatreResponseDto().getId()).get();

        show.setMovie(movie);
        show.setTheatre(theatre);
        show=showRepository.save(show);
        generateShowSeats(theatre.getThreatreSeats(),show);

        ShowResponseDto showResponseDto=ShowConvertor.convertEntityToDto(show,showEntryDto);
        return showResponseDto;
    }
    public void generateShowSeats(List<TheatreSeatsEntity> theatreSeats, ShowEntity show){
        List<ShowSeatsEntity> showSeats= new ArrayList<>();

        log.info("The list of theatre entity seats");
        for(TheatreSeatsEntity temp:theatreSeats){
            ShowSeatsEntity showSeatsEntity=ShowSeatsEntity.builder().seatNo(temp.getSeatNumber())
                            .seatType(temp.getSeatType()).rate(temp.getRate()).build();
            showSeats.add(showSeatsEntity);
        }
        for(ShowSeatsEntity showSeatsEntity:showSeats){
            showSeatsEntity.setShow(show);
        }
        showSeatsRepository.saveAll(showSeats);
        show.setSeats(showSeats);
    }

    @Override
    public ShowResponseDto getShow(int id) {
        ShowEntity show=showRepository.findById(id).get();
        //showEntry
        ShowEntryDto showEntryDto=null;
        ShowResponseDto showDto=ShowConvertor.convertEntityToDto(show,showEntryDto);
        return showDto;
    }
}
