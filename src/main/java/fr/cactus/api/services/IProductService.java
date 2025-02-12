package fr.cactus.api.services;

import java.util.List;
import java.util.Optional;

import fr.cactus.api.models.Product;

public interface IProductService {
    
    List<Product> getAllProducts();

    Optional<Product> getProductById(Long id);

    void createProduct(Product product);

}
