package com.projet.rentcar.web.models.requests;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class VoitureForm {
    
    private String Immatricule;
    private String marque;
    private Date date_mise_circulation;
    private Double prixLoc ;
    private String Image ;


    

}