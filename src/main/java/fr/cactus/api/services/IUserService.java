package fr.cactus.api.services;

import java.util.List;
import java.util.Optional;

import fr.cactus.api.dto.LoginRequest;
import fr.cactus.api.dto.LoginResponse;
import fr.cactus.api.dto.RegisterDto;
import fr.cactus.api.models.Users;

public interface IUserService {
    
    List<Users> getAllUsers();

    Optional<Users> findByUsername(String username);

    Boolean checkPassword(Optional<Users> user, String rawPassword);

    boolean registerUser(RegisterDto dto);

    String authenticateUser(String username, String password);

    LoginResponse loginUser(LoginRequest loginRequest);


}
