package com.attractor.shop.services;

import com.attractor.shop.entities.Category;
import com.attractor.shop.entities.Product;
import com.attractor.shop.repositories.CategoryRepository;
import com.attractor.shop.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public Product getById(Long id){
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()){
            return product.get();
        }else return null;
    }
    public List<Product> getProducts(Long categoryId){
        log.debug("I'm in service");
        return productRepository.getProductByCategory_Id(categoryId);
    };

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(Long categoryId, Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        if (categoryOptional.isPresent()){
            Category category = categoryOptional.get();
            Optional<Product> productOptional = category.getProducts().stream().filter(product -> product.getId().equals(id)).findFirst();
            if (productOptional.isPresent()){
                category.getProducts().remove(productOptional);
                productRepository.deleteById(id);
            }

        }
    }
}
