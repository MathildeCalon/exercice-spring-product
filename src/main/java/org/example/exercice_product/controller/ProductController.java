package org.example.exercice_product.controller;

import org.example.exercice_product.model.Product;
import org.example.exercice_product.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/list")
    public String list(Model model){
        List<Product> list = productService.getAllProducts();
        model.addAttribute("list", list);
        return "list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") UUID id, Model model){
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "detail";
    }
}
