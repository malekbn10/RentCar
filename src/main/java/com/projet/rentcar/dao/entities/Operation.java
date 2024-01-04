package com.projet.rentcar.dao.entities;


import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="operation")
@AllArgsConstructor
@Getter
@Setter
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dateDebut" )
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date dateDebut;

    @Column(name = "dateFin")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateFin;

    @Column(name = "garantie")
    private String garantie;

    @Column(name = "montantGarantie")
    private String montantGarantie;

    @Column(name = "fraisLoc")
    private Long fraisLoc;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nomClient", referencedColumnName = "name")
    private Client nomClient;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cinClient", referencedColumnName = "cin")
    private Client cinClient;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "immVoiture", referencedColumnName = "Immatricule")
    private Voiture immVoiture;

    public Long  countDay(Date dd,Date df){
        Long time_diff=dd.getTime() - df.getTime();
        Long days_difference = time_diff / (1000 * 60 * 60 * 24);  
        return days_difference;
    }
}