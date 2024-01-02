package com.projet.rentcar.dao.entities;


import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    private Date dateDebut;

    @Column(name = "dateFin")
    @Temporal(TemporalType.DATE)
    private Date dateFin;

    @Column(name = "garantie")
    private String garantie;

    @Column(name = "montantGarantie")
    private String montantGarantie;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nomClient", referencedColumnName = "name")
    private Client nomClient;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cinClient", referencedColumnName = "cin")
    private Client cinClient;
}