package com.projet.rentcar.business.services;


import java.util.Optional;

import com.projet.rentcar.dao.entities.Voiture;

import java.util.List;

public interface IVoitureService {
    public Optional<Voiture> getVoiture(String Immatricule);
    public Optional<Voiture> findByMarque(String marque);
    public void addVoiture (Voiture v);
    public void updateVoiture (Voiture v);
    public void deleteVoiture (String Immatricule);
    public List<Voiture> getAllVoiture();

}