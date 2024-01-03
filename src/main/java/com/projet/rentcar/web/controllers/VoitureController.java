package com.projet.rentcar.web.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.rentcar.business.services.IVoitureService;
import com.projet.rentcar.dao.entities.Voiture;

@RequestMapping("/cars")
public class VoitureController {

    // Retrieving All Cars
    @Autowired
    IVoitureService voitureService;

    @GetMapping()
    public String getAllCars(Model model) {
        List<Voiture> listvoiture=voitureService.getAllVoiture();
        model.addAttribute("listVoiture", listvoiture);
        return "carlist.html";
    }
/*
    // Retriving Cars By Marque
    @GetMapping("{marque}")
    public ResponseEntity<Object> findByMarque(@PathVariable("marque") String marque) {
        Optional<Voiture> voiture = voitureService.findByMarque(marque);
        if (voiture.isPresent()) {
            return new ResponseEntity<>(voiture.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed: Voiture not found", HttpStatus.NOT_FOUND);
        }

    }
*/
    // Adding a Car
  @GetMapping("/new")
    public String showCarForm(Model model) {
            model.addAttribute("voiture", new Voiture(null, null, null, null, null));
            return "carform";

        }
    @PostMapping("/save")
    public String  addCar(Voiture voiture) {
            voitureService.addVoiture(voiture);     
        return "redirect:/cars";
    }

    // Updating a Car
    @GetMapping("/update/{Immatricule}")
    public String showUpdateForm(@PathVariable("Immatricule") String Immatricule,Model model ){
            Optional<Voiture> voiture =voitureService.getVoiture(Immatricule);
            if (voiture !=null) {
            model.addAttribute("voiture", voiture);
                
            }
            return "carsForm";
    }

  

    // Deleting a Car
    @DeleteMapping("{id}/delete")
    public String deleteCar(@PathVariable("Immatricule") String Immatricule) {
        voitureService.deleteVoiture(Immatricule);
        return "redirect:/cars";
    }



}