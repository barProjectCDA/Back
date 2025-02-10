package fr.cactus.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.cactus.api.models.User;
import fr.cactus.api.services.UserService; // Import du modèle Category

@RestController
@RequestMapping("/auth")
public class ConnectionController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public List<User> showLogin() {
        return userService.getAllUsers();
    }

    @GetMapping("/register")
    public String showRegister() {
        return "register";
    }

}
