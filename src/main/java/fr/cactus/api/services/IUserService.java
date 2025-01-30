package fr.cactus.api.services;

import java.util.List;

import fr.cactus.api.models.User;

public interface IUserService {
    
    List<User> getAllUsers();
}
