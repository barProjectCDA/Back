package fr.cactus.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.cactus.api.models.Product;
import fr.cactus.api.services.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;
    
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping
    public void createProduct(@RequestBody Product product){
        productService.createProduct(product);
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id){
        return productService.getProductById(id);
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
