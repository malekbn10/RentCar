package com.projet.rentcar.dao.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.rentcar.dao.entities.Voiture;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture,String> {
    Optional<Voiture> findByMarque(String marque);
}