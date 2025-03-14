package fr.cactus.api.services;

import java.util.List;

import fr.cactus.api.models.Category;


public interface ICategoriesService {
    List<Category> getAllCategories();
    List<Category> getCategoriesWithSub();
    List<Category> getCategoriesWithSubCat();
    Category findById(Long categoryId);
}

