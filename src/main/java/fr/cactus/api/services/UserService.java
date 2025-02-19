package fr.cactus.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.cactus.api.dto.LoginRequest;
import fr.cactus.api.dto.RegisterDto;
import fr.cactus.api.models.User;
import fr.cactus.api.repositories.UserRepository;
import fr.cactus.api.security.JwtGenerator;

@Service
public class UserService implements IUserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtGenerator jwtGenerator;
    
    @Override
    public boolean registerUser(RegisterDto registerDto){
        if(userRepository.existsByUsername(registerDto.username())){
            return false;
        }
        User user = new User();
        user.setFirstName(registerDto.firstName());
        user.setLastName(registerDto.lastName());
        user.setUsername(registerDto.username());
        user.setAdmin(registerDto.isAdmin());
        user.setPassword(passwordEncoder.encode(registerDto.password()));

        userRepository.save(user);
        return true;
    }
 
    @Override
    public String loginUser(LoginRequest loginRequest) throws AuthenticationException {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return token;
    }
    
    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    public Boolean checkPassword(Optional<User> user, String rawPassword){
        return passwordEncoder.matches(rawPassword, user.get().getPassword());
    }


    @Override
    public String authenticateUser(String username, String rawPassword) {
        Optional<User> user = findByUsername(username);
        if (user == null) {
            return "User not found";
        }
        if (!checkPassword(user, rawPassword)) {
            return "Password failed";
        }
        return null;
    }
    
}
