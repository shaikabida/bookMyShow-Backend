package com.example.project.bookmyshowbackend.Service.Implementation;

import com.example.project.bookmyshowbackend.Convertor.TheatreConvertor;
import com.example.project.bookmyshowbackend.DTO.EntryDTO.TheatreEntryDto;
import com.example.project.bookmyshowbackend.DTO.ResponseDTO.TheatreResponseDto;
import com.example.project.bookmyshowbackend.ENUM.TheatreType;
import com.example.project.bookmyshowbackend.ENUM.seatType;
import com.example.project.bookmyshowbackend.Models.TheatreEntity;
import com.example.project.bookmyshowbackend.Models.TheatreSeatsEntity;
import com.example.project.bookmyshowbackend.Repository.TheatreRepository;
import com.example.project.bookmyshowbackend.Repository.TheatreSeatsRepository;
import com.example.project.bookmyshowbackend.Service.TheatreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TheatreServiceImplement implements TheatreService {
    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    TheatreSeatsRepository theatreSeatsRepository;

    @Override
    public TheatreResponseDto getTheatre(int id) {
        TheatreEntity theatre=theatreRepository.findById(id).get();
        TheatreResponseDto theatreResponseDto= TheatreConvertor.convertEntitytoDto(theatre);
        return theatreResponseDto;
    }

    @Override
    public TheatreResponseDto addTheatre(TheatreEntryDto theatreEntryDto) {
        TheatreEntity theatre=TheatreConvertor.convertDtoToEntity(theatreEntryDto);
        // create TheatreSeats
        List<TheatreSeatsEntity> seats=createTheatreSeats();
        theatre.setThreatreSeats(seats);
        theatre.setListOfShows(null);
        theatre.setType(TheatreType.SINGLE);
        for(TheatreSeatsEntity theatreSeats:seats){
            theatreSeats.setTheatre(theatre);
        }
       // log.info("The theatre entity is "+theatre);
        theatre=theatreRepository.save(theatre);
        TheatreResponseDto theatreResponseDto=TheatreConvertor.convertEntitytoDto(theatre);
        return theatreResponseDto;
    }
    public List<TheatreSeatsEntity> createTheatreSeats(){
        List<TheatreSeatsEntity> seats=new ArrayList<>();
        seats.add(generateSeat("1A",100, seatType.CLASSIC));
        seats.add(generateSeat("2A",100, seatType.CLASSIC));
        seats.add(generateSeat("3A",100, seatType.CLASSIC));
        seats.add(generateSeat("4A",100, seatType.CLASSIC));
        seats.add(generateSeat("5A",100, seatType.CLASSIC));

        seats.add(generateSeat("1B",150, seatType.DELUXE));
        seats.add(generateSeat("2B",150, seatType.DELUXE));
        seats.add(generateSeat("3B",150, seatType.DELUXE));
        seats.add(generateSeat("4B",150, seatType.DELUXE));
        seats.add(generateSeat("5B",150, seatType.DELUXE));
        theatreSeatsRepository.saveAll(seats);
        return seats;
    }
    public TheatreSeatsEntity generateSeat(String name, int rate, seatType seatType){
        return TheatreSeatsEntity.builder().seatNumber(name).rate(rate).seatType(seatType).build();
    }
}
