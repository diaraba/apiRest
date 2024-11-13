package com.demoRest.api.controller;

import com.demoRest.api.dto.CompteCreateDto;
import com.demoRest.api.dto.CompteDto;
import com.demoRest.api.entities.Compte;
import com.demoRest.api.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banque/comptes")
public class CompteController {
    @Autowired
    private CompteService compteService;
    @GetMapping(path = "", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<List<CompteDto>> compteList(){
        List<CompteDto> c1= compteService.getAllCompte();
        return new ResponseEntity<>(c1,HttpStatus.OK);
    }
    @GetMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE })
    public  ResponseEntity<CompteDto> getOne(@PathVariable(value = "id") Long id){
        CompteDto compteDto= compteService.getCompteById(id);
        return new ResponseEntity<>(compteDto,HttpStatus.OK);
    }

    @PostMapping(path = "")
    public CompteDto save(@RequestBody CompteCreateDto compteDto){return compteService.create(compteDto);}
    @PutMapping(path = "/{id}")
    public CompteDto update(@RequestBody CompteCreateDto compteDto ,@PathVariable(value = "id") Long id){
        compteDto.setId(id);
        return compteService.updateCompte(id,compteDto);
    }
    @DeleteMapping(path = "/{id}")
    public String delete(@PathVariable(value = "id") Long id){
        return compteService.deleteCompte(id);
    }
}
