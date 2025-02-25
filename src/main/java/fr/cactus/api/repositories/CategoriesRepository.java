package fr.cactus.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.cactus.api.models.Category;

public interface CategoriesRepository extends JpaRepository<Category, Long> {
    
    List<Category> findByMainCategoryIsNull();
}