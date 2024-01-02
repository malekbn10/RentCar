package com.projet.rentcar.web.controllers;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projet.rentcar.business.services.IOperationService;
import com.projet.rentcar.dao.entities.Operation;
@RequestMapping("/operations")
@Controller
public class OperationController {
    @Autowired
    IOperationService operationService;

    //Retrieving All Operations

    @GetMapping()
    public String getAllOperation(Model model) {
        java.util.List<Operation> listoperation=operationService.getAllOperation();      
        model.addAttribute("listoperation", listoperation);
        return "listoperation";
    }
     // Retriving Operation By ClientName
   /* @GetMapping("{name}")
    public ResponseEntity<Object> getOperation(@PathVariable("name") Client nomClient) {
        Optional<Operation> operation = operationService.getOperation(nomClient);
        if (operation.isPresent()) {
            return new ResponseEntity<>(operation.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed: Operation not found", HttpStatus.NOT_FOUND);
        }

    }*/

    // Adding an Operation
    @GetMapping("/new")
    public String showOperationForm(Model model) {
            model.addAttribute("operation", new Operation(null, null, 
            null, null, null, null, null));
            return "operationForm";

        }
    @PostMapping("/save")
    public String  addOperation(Operation operation) {
            operationService.addOperation(operation);        
        return "redirect:/operations";
    }
    

    // Updating an Operation
    @GetMapping("/update/{cin}")
    public String showUpdateForm(@PathVariable("id") Long id ,Model model ){
            Optional<Operation> operation =operationService.getOperationById(id);
            if (operation !=null) {
            model.addAttribute("operation", operation);
                
            }
            return "operationForm";
    }


    // Deleting an Operation
    @DeleteMapping("{id}/delete")
    public String deleteOperation(@PathVariable("id") Long id) {
        operationService.deleteOperation(id);
        return "redirect:/operations";
    }
 
}