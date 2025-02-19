package fr.cactus.api.services;

import java.util.List;
import java.util.Optional;

import fr.cactus.api.dto.LoginRequest;
import fr.cactus.api.dto.RegisterDto;
import fr.cactus.api.models.User;

public interface IUserService {
    
    List<User> getAllUsers();

    Optional<User> findByUsername(String username);

    Boolean checkPassword(Optional<User> user, String rawPassword);

    boolean registerUser(RegisterDto dto);

    String authenticateUser(String username, String password);

    String loginUser(LoginRequest loginRequest);


}
