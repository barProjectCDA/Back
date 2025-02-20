package fr.cactus.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.cactus.api.dto.Response;
import fr.cactus.api.models.Category;
import fr.cactus.api.services.CategoriesService;

@RestController
@RequestMapping("/category")

public class CategoryController {

    @Autowired
    private CategoriesService categoriesService;

    @GetMapping
    public ResponseEntity<?> getCategories() {

        if (categoriesService.getCategoriesWithSubCat().isEmpty()) {
            return new ResponseEntity<>(new Response("error", "Aucune catégorie"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categoriesService.getCategoriesWithSubCat(), HttpStatus.OK);
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
