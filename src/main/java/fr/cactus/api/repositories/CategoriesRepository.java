package fr.cactus.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.cactus.api.models.Category;
@Repository
public interface CategoriesRepository extends JpaRepository<Category, Long> {
    List<Category> findByMainCategoryIsNull();
    

}