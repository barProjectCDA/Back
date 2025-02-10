package fr.cactus.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cactus.api.models.Category;
import fr.cactus.api.repositories.CategoriesRepository;

@Service
public class CategoriesService implements ICategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoriesRepository.findAll();
    }

    public Category addCategory(Category category) {
        return categoriesRepository.save(category);
    }

    // Méthode pour supprimer une catégorie
    public void deleteCategory(Long id) {
        if (categoriesRepository.existsById(id)) {
            categoriesRepository.deleteById(id);
        } else {
            throw new RuntimeException("Category not found with id " + id);
        }
    }

    // Méthode pour mettre à jour une catégorie
    public Category updateCategory(Long id, Category categoryDetails) {
        // Cherche la catégorie par son ID
        Category category = categoriesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id " + id));

        // Met à jour les champs de la catégorie
        category.setName(categoryDetails.getName());
        category.setCssHexadecimalColor(categoryDetails.getCssHexadecimalColor());
        category.setMainCategory(categoryDetails.getMainCategory());

        // Sauvegarde et renvoie la catégorie mise à jour
        return categoriesRepository.save(category);
    }
}
