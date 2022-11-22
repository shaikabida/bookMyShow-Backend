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
        ShowTime show= ShowConvertor.convertDtoToEntity(showEntryDto);

        Movie movie = movieRepository.findById(showEntryDto.getMovieResponseDto().getId()).get();
        Theatre theatre=theatreRepository.findById(showEntryDto.getTheatreResponseDto().getId()).get();

        show.setMovie(movie);
        show.setTheatre(theatre);

        generateShowSeats(theatre.getThreatreSeats(),show);
        show=showRepository.save(show);
        ShowResponseDto showResponseDto=ShowConvertor.convertEntityToDto(show,showEntryDto);
        return showResponseDto;
    }
    public void generateShowSeats(List<TheatreSeats> theatreSeats, ShowTime show){
        List<ShowSeats> showSeats= new ArrayList<>();

        log.info("The list of theatre entity seats");
        for(TheatreSeats temp:theatreSeats){
            showSeats.add(generateShowSeatsEntity(temp,show));
        }
        showSeatsRepository.saveAll(showSeats);
    }
    public ShowSeats generateShowSeatsEntity(TheatreSeats theatreSeats, ShowTime show){
        return ShowSeats.builder().rate(theatreSeats.getRate()).seatNo(theatreSeats.getSeatNumber())
                .seatType(theatreSeats.getSeatType()).show(show).build();
    }

    @Override
    public ShowResponseDto getShow(int id) {
        ShowTime show=showRepository.findById(id).get();
        //showEntry
        ShowEntryDto showEntryDto=null;
        ShowResponseDto showDto=ShowConvertor.convertEntityToDto(show,showEntryDto);
        return showDto;
    }
}
