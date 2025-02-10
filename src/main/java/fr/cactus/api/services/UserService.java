package fr.cactus.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.cactus.api.models.User;
import fr.cactus.api.repositories.UserRepository;

@Service
public class UserService implements IUserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public User getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    public Boolean checkPassword(User user, String rawPassword){
        return passwordEncoder.matches(rawPassword, user.getPassword());
    }

    @Override
    public void registerUser(User user){
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        userRepository.save(user);
    }

    @Override
    public String authenticateUser(String username, String rawPassword) {
        User user = getUserByUsername(username);
        if (user == null) {
            return "User not found";
        }
        if (!checkPassword(user, rawPassword)) {
            return "Password failed";
        }
        return null;
    }
    
}
