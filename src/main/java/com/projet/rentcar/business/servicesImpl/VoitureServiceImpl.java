package com.projet.rentcar.business.servicesImpl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.rentcar.business.services.IVoitureService;
import com.projet.rentcar.dao.entities.Voiture;
import com.projet.rentcar.dao.repositories.VoitureRepository;

@Service
public class VoitureServiceImpl implements IVoitureService {

    @Autowired
    VoitureRepository voitureRepository;

    @Override
    public Optional<Voiture> getVoiture(String Immatricule) {
        return voitureRepository.findById(Immatricule);
    }
    @Override
    public Optional<Voiture> findByMarque(String marque){
        return voitureRepository.findByMarque(marque);
    }


    @Override
    public void addVoiture(Voiture v) {
        voitureRepository.save(v);
    }

    @Override
    public void updateVoiture(Voiture v) {
        voitureRepository.save(v);

    }

    @Override
    public void deleteVoiture(String Immatricule) {
        voitureRepository.deleteById(Immatricule);

    }

    @Override
    public List<Voiture> getAllVoiture() {
        return voitureRepository.findAll();

    }
    
}