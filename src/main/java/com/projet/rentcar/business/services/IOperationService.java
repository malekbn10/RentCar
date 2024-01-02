package com.projet.rentcar.business.services;


import java.util.List;
import java.util.Optional;

import com.projet.rentcar.dao.entities.Client;
import com.projet.rentcar.dao.entities.Operation;

public interface IOperationService {
    
    public Optional<Operation> getOperation(Client nomClient);
    public Optional<Operation> getOperationById(Long id);

    public void addOperation (Operation o);
    public void updateOperation (Operation o);
    public void deleteOperation (Long id);
    public List<Operation> getAllOperation();

}