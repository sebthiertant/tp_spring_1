package com.thiertant.ecommerce.controller;

import com.thiertant.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = { "", "/" })
    public String getProducts(Model model) {
        System.out.println("/products : get all products");
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

}
