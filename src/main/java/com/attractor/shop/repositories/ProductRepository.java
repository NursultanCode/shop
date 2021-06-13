package com.attractor.shop.repositories;

import com.attractor.shop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> getProductByCategory_Id(Long categoryId);
}
