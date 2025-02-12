package fr.cactus.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.cactus.api.dto.RegisterDto;
import fr.cactus.api.models.Users;
import fr.cactus.api.repositories.UserRepository;

@Service
public class UserService implements IUserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public List<Users> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public Optional<Users> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    public Boolean checkPassword(Optional<Users> user, String rawPassword){
        return passwordEncoder.matches(rawPassword, user.get().getPassword());
    }

    @Override
    public boolean registerUser(RegisterDto registerDto){
        if(userRepository.existsByUsername(registerDto.username())){
            return false;
        }
        Users user = new Users();
        user.setUsername(registerDto.username());
        user.setPassword(passwordEncoder.encode(registerDto.password()));
        user.setAdmin(registerDto.isAdmin());

        userRepository.save(user);

    return true;
    }

    @Override
    public String authenticateUser(String username, String rawPassword) {
        Optional<Users> user = findByUsername(username);
        if (user == null) {
            return "User not found";
        }
        if (!checkPassword(user, rawPassword)) {
            return "Password failed";
        }
        return null;
    }
    
}
