package fr.cactus.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.cactus.api.models.Category;

public interface CategoriesRepository extends JpaRepository<Category, Long> {
    
}