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

import fr.cactus.api.DTO.LoginRequest;
import fr.cactus.api.DTO.LoginResponse;
import fr.cactus.api.models.User;
import fr.cactus.api.services.UserService;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;


    @GetMapping("/login")
    public List<User> showLogin(){
        List<User> listUsers = userService.getAllUsers();

        return listUsers;
    }

    @PostMapping("/login")
    public ResponseEntity<?> logIn(@RequestBody LoginRequest loginRequest) {
    String errorMessage = userService.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword());

    if (errorMessage != null) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorMessage);
    }

    return ResponseEntity.ok(new LoginResponse(loginRequest.getUsername(), "token"));
}


    @GetMapping("/register")
    public String showRegister(){
        return "register";
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            userService.registerUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
