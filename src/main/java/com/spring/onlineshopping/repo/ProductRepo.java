package com.spring.onlineshopping.repo;

import com.spring.onlineshopping.Exception.product.ProductNotFoundException;
import com.spring.onlineshopping.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    public List<Product> findByProdName(String ProdName);
    public List<Product> findByProdCategory(String prodCategory);
    public Product findByProdId(int prodId);

}
