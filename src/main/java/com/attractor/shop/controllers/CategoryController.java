package com.attractor.shop.controllers;

import com.attractor.shop.repositories.CategoryRepository;
import com.attractor.shop.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping({"/","index"})
    public String getCategories(Model model){
        model.addAttribute("categories", categoryService.getCategories());
        return "index";
    }
}
