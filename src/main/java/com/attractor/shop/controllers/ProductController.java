package com.attractor.shop.controllers;

import com.attractor.shop.dto.ProductDto;
import com.attractor.shop.entities.Category;
import com.attractor.shop.entities.Product;
import com.attractor.shop.exceptions.NotFoundException;
import com.attractor.shop.services.CategoryService;
import com.attractor.shop.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class ProductController {
    private final CategoryService categoryService;
    private final ProductService productService;
    @GetMapping("/categories/{categoryId}/products")
    public String getProducts(@PathVariable String categoryId, Model model,@PageableDefault(value = 2) Pageable pageable){
        final Page<Product> products = productService.getProductsPage(pageable);
        model.addAttribute("products", products.getContent());
        model.addAttribute("pages",products.getPageable());
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
    public String saveOrUpdate(@PathVariable String categoryId, @Valid @ModelAttribute("product") Product product, BindingResult bindingResult){
        product.setCategory(categoryService.getCategoryById(Long.valueOf(categoryId)));
        if (bindingResult.hasErrors()){
            return "product/form";
        }
        Product savedProduct = productService.saveProduct(product);
        return "redirect:/categories/" + savedProduct.getCategory().getId() + "/products";
    }

    @GetMapping("categories/{categoryId}/products/{id}/delete")
    public String deleteProduct(@PathVariable String categoryId,
                                @PathVariable String id){
                productService.deleteById(Long.valueOf(categoryId),Long.valueOf(id));
        return "redirect:/categories/" + categoryId + "/products";

    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception e){
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("404error");
            modelAndView.addObject("exception", e);
            return modelAndView;
    }
}
