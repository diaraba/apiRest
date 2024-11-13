package com.demoRest.api.service;

import com.demoRest.api.dto.CompteCreateDto;
import com.demoRest.api.dto.CompteDto;
import com.demoRest.api.entities.Compte;

import java.util.List;

public interface CompteServiceInterface {
    List<CompteDto> getAllCompte();
    CompteDto getCompteById(Long id);
    CompteDto create(CompteCreateDto compte);
    CompteDto updateCompte(Long id,CompteCreateDto compte);
    String deleteCompte(Long id);
}
