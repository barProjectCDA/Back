package fr.cactus.api.controllers;

import java.util.List;
import java.util.Optional;

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
import fr.cactus.api.models.Product;
import fr.cactus.api.services.CategoriesService;
import fr.cactus.api.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    CategoriesService categoriesService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/category/{categoryId}")
    public List<Product> getProductsByCategory(@PathVariable Long categoryId) {
        Category category = categoriesService.findById(categoryId);
        return productService.getProductByCategory(category);
    }

    @PostMapping
    public void createProduct(@RequestBody Product product) {
        productService.createProduct(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {

        Optional<Product> optionalProduct = productService.getProductById(id);

        if (optionalProduct.isPresent()) {
            return new ResponseEntity<>(optionalProduct.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(new Response("error", "Identifiant utilisateur non connu."), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable long id) {
        productService.deleteProduct(id);
    }

    @PutMapping
    public void UpdateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
    }
}
