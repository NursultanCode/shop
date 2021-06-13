package com.attractor.shop.services;

import com.attractor.shop.entities.Product;
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

    public Optional<Product> getById(Long id){
        return productRepository.findById(id);
    }
    public List<Product> getProducts(Long categoryId){
        log.debug("I'm in service");
        return productRepository.getProductByCategory_Id(categoryId);
    };
}
