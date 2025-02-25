package fr.cactus.api.services;

import java.util.List;
import java.util.Optional;

import fr.cactus.api.models.Category;
import fr.cactus.api.models.Product;

public interface IProductService {
    
    List<Product> getAllProducts();

    Optional<Product> getProductById(Long id);

    List<Product>getProductByCategory(Category category);

    void createProduct(Product product);
    
    void deleteProduct(long id);

    void updateProduct (Product product);

}