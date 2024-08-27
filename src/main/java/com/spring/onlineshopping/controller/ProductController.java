package com.spring.onlineshopping.controller;

import com.spring.onlineshopping.dto.Product;
import com.spring.onlineshopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shop/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @GetMapping
    public List<Product> getProducts() {
        return productService.findAll();

    }
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.save(product);
    }
    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        return productService.save(product);
    }
    @GetMapping("/prodId")
    public Product getProduct(@RequestParam int prodId) {
        return productService.findByProdId(prodId);
    }
    @DeleteMapping("/del")
    public void deleteProduct(@RequestParam int prodId) {
        productService.delete(prodId);
    }
    @GetMapping("/prodName")
    public List<Product> getProductsByProdName(@RequestBody String prodName) {
       return productService.findByName(prodName);
    }
    @GetMapping("/category")
    public List<Product> getProductByCategory(@RequestParam String category) {
        return productService.findByProdCategory(category);
    }


}
