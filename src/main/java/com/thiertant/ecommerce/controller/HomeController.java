package com.thiertant.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "Bienvenue sur mon super site";
    }

    @GetMapping("/bonjour")
    public String printBonjour() {
        return "Ici on dit bonjour";
    }
}
