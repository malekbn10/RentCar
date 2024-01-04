package com.projet.rentcar.dao.entities;


import java.util.Date;

import org.apache.tomcat.util.codec.binary.Base64;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="Voitures")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Voiture {


    @Id
    @Column(name="immatricule")
    private String Immatricule;
    
    @Column(name = "marque", length = 9, nullable = false,unique =false)
    private String marque;
    
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date_mise_circulation;

    @Column(name = "prixloc", length = 5, nullable = false,unique =false)
    private Long prixLoc ;

  
    @Column(name = "dispo")
    private String dispo ;

   
}