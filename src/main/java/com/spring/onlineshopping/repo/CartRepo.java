package com.spring.onlineshopping.repo;

import com.spring.onlineshopping.dto.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<Cart,Integer> {

}
