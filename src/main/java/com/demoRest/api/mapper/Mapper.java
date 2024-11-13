package com.demoRest.api.mapper;

import com.demoRest.api.Enum.ERole;
import com.demoRest.api.dto.UserResponseDto;
import com.demoRest.api.entities.Role;
import com.demoRest.api.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

import java.util.Set;
import java.util.stream.Collectors;

public class Mapper {
    @Bean
    public static ModelMapper getMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.typeMap(User.class, UserResponseDto.class).addMappings(mapper ->
                mapper.<Set<ERole>>map(src -> src.getRoles().stream()
                                .map(Role::getName)
                                .collect(Collectors.toSet()),
                        UserResponseDto::setRole)
        );

        return modelMapper;

    }
}
