package com.example.PCStore.controller;

import com.example.PCStore.model.Product;
import com.example.PCStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String findAll(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products",products);
        return "product-userlist";
    }

    @GetMapping("/products-admin")
    public String findAllAdmin(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products",products);
        return "product-list";
    }

    @GetMapping("/product-create")
    public String createProductForm(Product product){
        return "product-create";
    }

    @PostMapping("/product-create")
    public String createProduct(Product product){
        productService.saveProduct(product);
        return "redirect:/products-admin";
    }

    @GetMapping("/product-delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
        productService.deleteById(id);
        return "redirect:/products-admin";
    }

    @GetMapping("/product-update/{id}")
    public String updateProductForm(@PathVariable("id") Long id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "product-update";
    }

    @PostMapping("/product-update")
    public String updateProduct(Product product){
        productService.saveProduct(product);
        return "redirect:/products-admin";
    }
}
