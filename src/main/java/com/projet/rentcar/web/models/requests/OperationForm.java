package com.projet.rentcar.web.models.requests;


import java.util.Date;

import com.projet.rentcar.dao.entities.Client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class OperationForm {
    
    private Long id;
    private Date dateDebut;
    private Date dateFin;
    private String garantie;
    private String montantGarantie;
    private Client nomClient;
    private Client cinClient;

}