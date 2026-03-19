package com.security.oauth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/home")
    public String home() {
        return "Welcome to the Home Page!";
    }

}
