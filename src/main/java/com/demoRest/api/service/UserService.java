package com.demoRest.api.service;

import com.demoRest.api.Enum.ERole;
import com.demoRest.api.dto.UserResponseDto;
import com.demoRest.api.entities.Role;
import com.demoRest.api.entities.User;
import com.demoRest.api.exception.RessourceNotFoundException;
import com.demoRest.api.mapper.MyMapper;
import com.demoRest.api.repositories.RoleRepository;
import com.demoRest.api.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    public ModelMapper mapper;
    @Autowired
    public MyMapper myMapper;

    @Override
    public List<UserResponseDto> getAllClient() {
        return userRepository.findAll().stream().map(UserResponseDto::new).toList();
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(()->new RessourceNotFoundException("Aucun client trouver"));
        return new UserResponseDto(user);
    }

    @Override
    public List<UserResponseDto> getClientByRole(String role) {
        Role modRole;
        if(Objects.equals(role, "client"))
             modRole = roleRepository.findByName(ERole.ROLE_CLIENT).orElseThrow(()->new RessourceNotFoundException("Aucun client trouver"));
        else {
            modRole = new Role();
        }
        return userRepository.findAll().stream()
                .filter(user1 -> user1.getRoles().stream()
                .anyMatch(role1 -> role1.getName() == modRole.getName()))
                .map(UserResponseDto::new)
                .toList();
    }

    @Override
    public UserResponseDto create(UserResponseDto userResponseDto) {
        User user =mapper.map(userResponseDto, User.class);
        /*if(userRepository.existsByName(user.getName()))
            throw new ConflictRessourceException("Ce nom existe déjà");*/
        userRepository.save(user);
        return mapper.map(user, UserResponseDto.class);
    }

    @Override
    public UserResponseDto updateClient(Long id, UserResponseDto userResponseDto) {
        User user =mapper.map(userResponseDto, User.class);
        user.setId(id);
        User oldUser = userRepository.findById(id).orElseThrow(()-> new RessourceNotFoundException("Ce client n'existe pas"));

       /* if( (userRepository.existsByName(user.getName()) & ! Objects.equals(oldUser.getName(), user.getName())))
            throw new ConflictRessourceException("Ce nom existe déjà");*/
        userRepository.save(user);
        return mapper.map(user, UserResponseDto.class);
    }

    @Override
    public String deleteClient(Long id) {
        if(userRepository.findById(id).isEmpty())
            throw new RessourceNotFoundException("Ce client n'existe pas");
        userRepository.deleteById(id);
        return "Client supprimer avec succès";
    }
}