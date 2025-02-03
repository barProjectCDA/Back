package fr.cactus.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.cactus.api.DTO.LoginRequest;
import fr.cactus.api.DTO.LoginResponse;
import fr.cactus.api.models.User;
import fr.cactus.api.services.UserService;
import jakarta.validation.Valid;


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
    public ResponseEntity<?> logIn(@RequestBody LoginRequest loginRequest){
        User user = userService.getUserByUsername(loginRequest.getUsername());

        if(user == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found");
        }

        if(!userService.checkPassword(user, loginRequest.getPassword())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Password failed");
        }
        
        return ResponseEntity.ok(new LoginResponse(user.getUsername(), "token"));
    }

    @GetMapping("/register")
    public String showRegister(){
        return "register";
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            StringBuilder errorMessages = new StringBuilder();
            result.getAllErrors().forEach(error -> errorMessages.append(error.getDefaultMessage()).append(" "));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages.toString());
        }
        
        try {
            userService.registerUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
