package com.attractor.shop.services;

import com.attractor.shop.entities.Product;
import com.attractor.shop.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Optional<Product> getById(Long id){
        return productRepository.findById(id);
    }
}
