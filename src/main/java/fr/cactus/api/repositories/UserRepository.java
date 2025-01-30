package fr.cactus.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.cactus.api.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
