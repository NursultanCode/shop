package com.attractor.shop.repositories;

import com.attractor.shop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> getProductByCategory_Id(Long categoryId);
    List<Product> findAllByNameContaining(String name);
    List<Product> findAllByNameContainingAndCostGreaterThanEqualAndCostLessThanEqual(@NotBlank @Size(min = 2, max = 20) String name, @Min(1) float costMin, @Min(1) float costMax);
}
