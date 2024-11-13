package com.demoRest.api.dto;

import com.demoRest.api.Enum.TypeCompte;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CompteCreateDto {
    private Long id;
    private double solde;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Enumerated(EnumType.STRING)
    private TypeCompte type;
    private Long idClient;

}
