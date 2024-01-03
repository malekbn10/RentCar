package com.projet.rentcar.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/home")
@Controller
public class MainController {
    @GetMapping()
    public String home() {
        return "template.html";
    }
}