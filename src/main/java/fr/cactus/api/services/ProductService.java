package fr.cactus.api.services;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cactus.api.models.Category;
import fr.cactus.api.models.Product;
import fr.cactus.api.repositories.ProductRepository;

@Service
public class ProductService implements IProductService {
    
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    @Override
    public List<Product>getProductByCategory(Category category){
        return productRepository.findByCategory(category);
    }

    @Override
    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }

    @Override
    public void createProduct(Product product){
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(long id){
        productRepository.deleteById(id);
    }

    @Override
    public void updateProduct(Product product){
        productRepository.save(product);
    }
}
