package com.example.project.bookmyshowbackend.Convertor;

import com.example.project.bookmyshowbackend.DTO.EntryDTO.ShowEntryDto;
import com.example.project.bookmyshowbackend.DTO.ResponseDTO.ShowResponseDto;
import com.example.project.bookmyshowbackend.Models.ShowEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ShowConvertor {
    public static ShowEntity convertDtoToEntity(ShowEntryDto showEntryDto){
        return ShowEntity.builder().showDate(showEntryDto.getShowDate()).showTime(showEntryDto.getShowTime()).build();
    }
    public static ShowResponseDto convertEntityToDto(ShowEntity show, ShowEntryDto showEntryDto){
        return ShowResponseDto.builder().id(show.getId()).showDate(show.getShowDate()).showTime(show.getShowTime())
                .movieResponseDto(showEntryDto.getMovieResponseDto())
                .theatreResponseDto(showEntryDto.getTheatreResponseDto())
        .build();
    }
}
