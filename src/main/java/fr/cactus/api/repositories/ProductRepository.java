package fr.cactus.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.cactus.api.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
