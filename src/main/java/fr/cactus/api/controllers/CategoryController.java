package fr.cactus.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.cactus.api.models.Category;
import fr.cactus.api.services.CategoriesService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoriesService categoriesService;

    @GetMapping
    public List<Category> getCategories() {
        return categoriesService.getAllCategories();
    }
    
    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoriesService.addCategory(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
    categoriesService.deleteCategory(id);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category category) {
        return categoriesService.updateCategory(id, category);
    }
}
