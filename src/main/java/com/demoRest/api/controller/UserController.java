package com.demoRest.api.controller;

import com.demoRest.api.dto.UserResponseDto;
import com.demoRest.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banque/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    @GetMapping(path = "", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<List<UserResponseDto>> compteList(){
        List<UserResponseDto> c1= userService.getAllClient();
        return ResponseEntity.ok(c1);
    }
    @GetMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE })
    public UserResponseDto getOne(@PathVariable(value = "id") Long id){return userService.getUserById(id);}

    @PostMapping(path = "")
    public UserResponseDto save(@RequestBody UserResponseDto userResponseDto){return userService.create(userResponseDto);}

    @PutMapping(path = "/{id}")
    public UserResponseDto update(@RequestBody UserResponseDto userResponseDto, @PathVariable(value = "id") Long id){
        return userService.updateClient(id, userResponseDto);
    }

    @DeleteMapping(path = "/{id}")
    public String delete(@PathVariable(value = "id") Long id){
        return userService.deleteClient(id);
    }
}