package com.attractor.shop.dto;

import com.attractor.shop.entities.Category;
import com.attractor.shop.entities.Product;
import com.attractor.shop.services.CategoryService;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
@Data
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private float cost;
    private byte[] image;
    private int count;
    private String description;
    private Long category;

}
