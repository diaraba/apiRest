package com.demoRest.api.service;

import com.demoRest.api.dto.UserResponseDto;

import java.util.List;

public interface UserServiceInterface {
    List<UserResponseDto> getAllClient();
    UserResponseDto getUserById(Long id);
    List<UserResponseDto> getClientByRole(String role);
    UserResponseDto create(UserResponseDto userResponseDto);
    UserResponseDto updateClient(Long id, UserResponseDto userResponseDto);
    String deleteClient(Long id);
}
