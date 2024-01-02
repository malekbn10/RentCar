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
import com.projet.rentcar.business.services.IClientService;
import com.projet.rentcar.dao.entities.Client;

@RequestMapping("/clients")
@Controller
public class ClientController {
    // Retrieving All Clients
    @Autowired
    IClientService clientService;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/clientsList")
    public String getAllClient(Model model) {
        java.util.List<Client> listclient=clientService.getAllClient();        
        model.addAttribute("listClient", listclient);
        return "listClient";
    }

 

    // Adding a Client
    @GetMapping("/new")
    public String showClientsFrom(Model model){
        model.addAttribute("client", new Client(null, null, null, null));
        return "clientForm";
    }
    @PostMapping("/save")
    public String addClient(Client client) {
            clientService.addClient(client);
        return "redirect:/clients";
    }

    // Updating a Client
    @GetMapping("/update/{cin}")
    public String showUpdateForm(@PathVariable("cin") Long cin ,Model model ){
            Optional<Client> client =clientService.getClient(cin);
            if (client !=null) {
            model.addAttribute("client", client);
                
            }
            return "clientForm";
    }

    // Deleting a Client
    @DeleteMapping("{cin}/delete")
    public String deleteVoiture(@PathVariable("cin") Long cin) {
        clientService.deleteClient(cin);
        return "redirect:/clients";
    }




     // Retriving Client By Name
   /* @GetMapping("/{name}")
    public String getClient(@PathVariable("name") Long cin) {
        Optional<Client> client = clientService.getClient(cin);
        if (client.isPresent()) {
            return new ResponseEntity<>(client.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed: Client not found", HttpStatus.NOT_FOUND);
        }

    }*/
}







  