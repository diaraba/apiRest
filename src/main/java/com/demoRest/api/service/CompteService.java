package com.demoRest.api.service;

import com.demoRest.api.dto.CompteCreateDto;
import com.demoRest.api.dto.CompteDto;
import com.demoRest.api.dto.UserResponseDto;
import com.demoRest.api.entities.User;
import com.demoRest.api.entities.Compte;
import com.demoRest.api.exception.RessourceNotFoundException;
import com.demoRest.api.mapper.MyMapper;
import com.demoRest.api.repositories.UserRepository;
import com.demoRest.api.repositories.CompteRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CompteService implements CompteServiceInterface{

    public CompteRepository compteRepository;
    public UserRepository userRepository;
    @Autowired
    public ModelMapper mapper;
    @Autowired
    public MyMapper myMapper;

    @Transactional(readOnly = true)
    @Override
    public List<CompteDto> getAllCompte() {
        return compteRepository.findAll().stream()
                .map(c-> {
                    CompteDto dto=mapper.map(c,CompteDto.class);
                    dto.setClient(new UserResponseDto(c.getUser()));
                    return dto;
                }).toList();
    }

    @Transactional(readOnly = true)
    @Override
    public CompteDto getCompteById(Long id) {
        Compte compte=compteRepository.findById(id).orElseThrow(()->new RessourceNotFoundException("Aucun client trouvé "));
        CompteDto compteDto=myMapper.convert(compte,new CompteDto());
        compteDto.setClient(new UserResponseDto(compte.getUser()));
        return compteDto;
    }

    @Transactional
    @Override
    public CompteDto create(CompteCreateDto compteDto) {
        Compte compte=mapper.map(compteDto, Compte.class);
        User user;
        if (compteDto.getIdClient() !=null) {
            System.out.println(compteDto.getIdClient());
            user = userRepository.findById(compteDto.getIdClient()).orElseThrow(() -> new RessourceNotFoundException("Aucun utilisateur trouvé "));
        }else{
            user=new User();
        }
        compte.setUser(user);
        compteRepository.save(compte);
        CompteDto compteDto1=myMapper.convert(compte,new CompteDto());
        compteDto1.setClient(new UserResponseDto(compte.getUser()));
        return compteDto1;
    }

    @Transactional(readOnly = true)
    @Override
    public CompteDto updateCompte(Long id, CompteCreateDto compteDto) {
        Compte compte=mapper.map(compteDto, Compte.class);
        Compte compteOld=compteRepository.findById(id).orElseThrow(()-> new RessourceNotFoundException("Aucun compte trouver"));
        User user =null;
        if (compteDto.getIdClient() !=null)
            user = userRepository.findById(compteOld.getId()).orElseThrow(()-> new RessourceNotFoundException("Aucun client trouvé "));
        compte.setUser(user ==null?compteOld.getUser(): user);
        compte.setId(id);
        CompteDto compteDto1=myMapper.convert(compte,new CompteDto());
        compteDto1.setClient(new UserResponseDto(compte.getUser()));
        compteRepository.save(compte);
        return compteDto1;
    }

    @Transactional
    @Override
    public String deleteCompte(Long id) {
        String message;
        if(compteRepository.existsById(id)) {
            compteRepository.deleteById(id);
            message="Compte supprimer avec succès";
        }else {
            message="La suppression a échouée";
        }
        return message;
    }
}
