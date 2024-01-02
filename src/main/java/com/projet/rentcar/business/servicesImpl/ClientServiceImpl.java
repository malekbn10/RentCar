package com.projet.rentcar.business.servicesImpl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.rentcar.business.services.IClientService;
import com.projet.rentcar.dao.entities.Client;
import com.projet.rentcar.dao.repositories.ClientRepository;
@Service
public class ClientServiceImpl  implements IClientService{

    @Autowired
    ClientRepository clientRepository;
    @Override
    public Optional<Client> getClient(Long cin) {
        return clientRepository.findById(cin);
    }

    @Override
    public void addClient(Client c) {
        clientRepository.save(c);
     }

    @Override
    public void updateClient(Client c) {

        clientRepository.save(c);
    }

    @Override
    public void deleteClient(Long cin) {
        clientRepository.deleteById(cin);
    }

    @Override
    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }
    
}