package com.projet.rentcar.dao.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.rentcar.dao.entities.Client;

@Repository

public interface ClientRepository extends JpaRepository<Client,Long> {
    Optional<Client>  findByCin(Long cin);
}