package com.attractor.shop.controllers;

import com.attractor.shop.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping("/categories/{categoryId}/products")
    public String getProducts(@PathVariable String categoryId,Model model){
        model.addAttribute("products", productService.getProducts(Long.valueOf(categoryId)));
        return "products";
    }
}
