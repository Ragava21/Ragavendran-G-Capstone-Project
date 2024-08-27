package com.spring.onlineshopping.service;

import com.spring.onlineshopping.Exception.product.ProductNotFoundException;
import com.spring.onlineshopping.dto.Product;
import com.spring.onlineshopping.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
Product product=new Product();
    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Product findByProdId(int prodId) {
     Product product1=productRepo.findByProdId(prodId);
        if(product1==null){
            throw new ProductNotFoundException("Product not found");
        }
     return product1;
    }

    @Override
    public Product save(Product product) {
       return productRepo.save(product);
    }



    @Override
    public void delete(int prodId) {
        if(!productRepo.existsById(prodId)) {
            throw new ProductNotFoundException("Product not found");
        }
        productRepo.deleteById(prodId);

    }

    @Override
    public List<Product> findByName(String ProdName) {
        return productRepo.findByProdName(ProdName);
    }

    @Override
    public List<Product> findByProdCategory(String prodCategory) {
        return productRepo.findByProdCategory(prodCategory);
    }
}
