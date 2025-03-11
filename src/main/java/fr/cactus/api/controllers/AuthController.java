package fr.cactus.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.cactus.api.dtos.LoginRequest;
import fr.cactus.api.dtos.LoginResponse;
import fr.cactus.api.dtos.RegisterDto;
import fr.cactus.api.dtos.Response;
import fr.cactus.api.models.User;
import fr.cactus.api.services.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public List<User> showLogin() {
        List<User> listUsers = userService.getAllUsers();

        return listUsers;
    }

    @PostMapping("/login")
    public ResponseEntity<?> logIn(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = LoginResponse.builder()
                                                        .username(loginRequest.getUsername())
                                                        .build();
        try {
            String token = userService.loginUser(loginRequest);
            loginResponse.setToken(token);
            loginResponse.setStatus("success");
            loginResponse.setMessage("Connexion réussie!");

            return new ResponseEntity<>(loginResponse, HttpStatus.OK);

        } catch (AuthenticationException e) {
    
            loginResponse.setStatus("error");
            loginResponse.setMessage("Erreur lors de l'authentification.");

            return new ResponseEntity<>(loginResponse, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Response> registerUser(@RequestBody RegisterDto dto) {

        boolean auth = userService.registerUser(dto);

        if (auth) {
            return new ResponseEntity<>(new Response("success", "Utilisateur enregistré avec succès."), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Response("error", "Nom d'utilisateur déjà utilisé."), HttpStatus.BAD_REQUEST);
        }

        // try {
        //     userService.registerUser(user);
        //     return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
        // } catch (RuntimeException e) {
        //     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        // }
    }
}
