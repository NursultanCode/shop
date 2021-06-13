package com.attractor.shop.services;

import com.attractor.shop.entities.Category;
import com.attractor.shop.entities.Product;
import com.attractor.shop.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public List<Category> getCategories(){
        log.debug("I'm in service");
        List<Category> categoriesSet = new ArrayList<>();
        categoryRepository.findAll().iterator().forEachRemaining(categoriesSet::add);
        return categoriesSet;
    };
    public Category getCategoryById(Long id){
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()){
            return category.get();
        }else return null;
    }

}
