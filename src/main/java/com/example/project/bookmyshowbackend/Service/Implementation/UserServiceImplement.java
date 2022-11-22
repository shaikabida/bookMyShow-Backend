package com.example.project.bookmyshowbackend.Service.Implementation;

import com.example.project.bookmyshowbackend.Convertor.UserConvertor;
import com.example.project.bookmyshowbackend.DTO.EntryDTO.UserEntryDto;
import com.example.project.bookmyshowbackend.DTO.ResponseDTO.UserResponseDto;
import com.example.project.bookmyshowbackend.Models.UserEntity;
import com.example.project.bookmyshowbackend.Repository.UserRepository;
import com.example.project.bookmyshowbackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplement implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserResponseDto addUser(UserEntryDto userEntryDto) {
        //create a funtion that converts userDto to user
        UserEntity userEntity= UserConvertor.convertDtoToEntity(userEntryDto);
        userRepository.save(userEntity);
        UserResponseDto userResponseDto=UserConvertor.convertEntityToDto(userEntity);
        return userResponseDto;
    }

    @Override
    public UserResponseDto getUser(int id) {
        UserEntity userEntity=userRepository.findById(id).get();
        UserResponseDto userDto=UserConvertor.convertEntityToDto(userEntity);
        return userDto;
    }
}
