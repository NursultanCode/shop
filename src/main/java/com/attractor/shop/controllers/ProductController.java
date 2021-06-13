package com.attractor.shop.controllers;

import com.attractor.shop.dto.ProductDto;
import com.attractor.shop.entities.Category;
import com.attractor.shop.entities.Product;
import com.attractor.shop.services.CategoryService;
import com.attractor.shop.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class ProductController {
    private final CategoryService categoryService;
    private final ProductService productService;
    @GetMapping("/categories/{categoryId}/products")
    public String getProducts(@PathVariable String categoryId,Model model){
        model.addAttribute("products", productService.getProducts(Long.valueOf(categoryId)));
        model.addAttribute("category",categoryService.getCategoryById(Long.valueOf(categoryId)));
        return "products";
    }
    @GetMapping("/categories/{categoryId}/products/{id}/show")
    public String getProducts(@PathVariable String categoryId,@PathVariable String id,Model model){
        model.addAttribute("product", productService.getById(Long.valueOf(id)));
        return "product/show";
    }
    @GetMapping("/categories/{categoryId}/products/new")
    public String newProduct(@PathVariable String categoryId, Model model){
        Category category = categoryService.getCategoryById(Long.valueOf(categoryId));
        Product product = new Product();
        product.setCategory(category);
        model.addAttribute("product", product);
        return "product/form";
    }
    @PostMapping("categories/{categoryId}/product")
    public String saveOrUpdate(@PathVariable String categoryId,@ModelAttribute Product product){
        product.setCategory(categoryService.getCategoryById(Long.valueOf(categoryId)));
        Product savedProduct = productService.saveProduct(product);
        return "redirect:/categories/" + savedProduct.getCategory().getId() + "/products";
    }

    @GetMapping("categories/{categoryId}/products/{id}/delete")
    public String deleteProduct(@PathVariable String categoryId,
                                @PathVariable String id){
                productService.deleteById(Long.valueOf(categoryId),Long.valueOf(id));
        return "redirect:/categories/" + categoryId + "/products";

    }
}
