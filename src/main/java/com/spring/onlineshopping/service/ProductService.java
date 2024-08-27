package com.spring.onlineshopping.service;

import com.spring.onlineshopping.Exception.product.ProductNotFoundException;
import com.spring.onlineshopping.dto.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAll();
    public Product findByProdId(int prodId) throws ProductNotFoundException;
    public Product save(Product product);
    public void delete(int prodId) throws ProductNotFoundException;
    public List<Product> findByName(String ProdName);
    public List<Product> findByProdCategory(String prodCategory);
}
