package com.example.project.bookmyshowbackend.Convertor;

import com.example.project.bookmyshowbackend.DTO.EntryDTO.UserEntryDto;
import com.example.project.bookmyshowbackend.DTO.ResponseDTO.UserResponseDto;
import com.example.project.bookmyshowbackend.Models.UserEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserConvertor {
    public static UserEntity convertDtoToEntity(UserEntryDto userEntryDto){
        return UserEntity.builder().name(userEntryDto.getName()).mobileNumber(userEntryDto.getMobileNumber()).build();
    }
    public static UserResponseDto convertEntityToDto(UserEntity userEntity){
        return UserResponseDto.builder().id(userEntity.getId()).name(userEntity.getName()).mobileNumber(userEntity.getMobileNumber()).build();
    }
}
