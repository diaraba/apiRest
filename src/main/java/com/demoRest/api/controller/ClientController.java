package com.demoRest.api.controller;

import com.demoRest.api.dto.UserResponseDto;
import com.demoRest.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/banque/clients")
public class ClientController {
    @Autowired
    private UserService userService;

    @GetMapping(path = "", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE })
    public ResponseEntity<List<UserResponseDto>> getAll(){
        List<UserResponseDto> userResponseDtos= userService.getClientByRole("client");
        return new ResponseEntity<>(userResponseDtos, HttpStatus.OK);
    }
}