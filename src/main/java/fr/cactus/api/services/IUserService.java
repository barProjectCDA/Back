package fr.cactus.api.services;

import java.util.List;

import fr.cactus.api.models.User;

public interface IUserService {
    
    List<User> getAllUsers();

    User getUserByUsername(String username);

    Boolean checkPassword(User user, String rawPassword);

    void registerUser(User user);

    String authenticateUser(String username, String password);
}
