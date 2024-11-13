package com.demoRest.api.dto;

import com.demoRest.api.entities.Compte;
import com.demoRest.api.Enum.TypeCompte;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.BeanUtils;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CompteDto {
    private Long id;
    private double solde;
    private Date dateCreation;
    private TypeCompte type;
    private UserResponseDto client;
    public CompteDto(Compte compte){
        BeanUtils.copyProperties(compte, new CompteDto());
    }
}