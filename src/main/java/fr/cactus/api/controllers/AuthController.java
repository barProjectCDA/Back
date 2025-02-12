package fr.cactus.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.cactus.api.dto.LoginRequest;
import fr.cactus.api.dto.LoginResponse;
import fr.cactus.api.dto.Message;
import fr.cactus.api.dto.RegisterDto;
import fr.cactus.api.models.Users;
import fr.cactus.api.services.UserService;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;


    @GetMapping("/login")
    public List<Users> showLogin(){
        List<Users> listUsers = userService.getAllUsers();

        return listUsers;
    }

    @PostMapping("/login")
    public ResponseEntity<?> logIn(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = userService.loginUser(loginRequest);
        if(loginResponse.isAuthenticated()){
            System.out.println(loginResponse.getToken());
            return new ResponseEntity<>(new Message("success", "Utilisateur identifié avec succés."), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(new Message("error", "Identifiant ou mot de passe incorrect."), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Message> registerUser(@RequestBody RegisterDto dto) {
     
        boolean auth = userService.registerUser(dto);

        if(auth){
            return new ResponseEntity<>(new Message("success", "Utilisateur enregistré avec succès."), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Message("error", "Nom d'utilisateur déjà utilisé."), HttpStatus.BAD_REQUEST);
        }
     
        // try {
        //     userService.registerUser(user);
        //     return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
        // } catch (RuntimeException e) {
        //     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        // }
    }
}
