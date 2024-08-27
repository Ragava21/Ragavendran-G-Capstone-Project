package com.spring.onlineshopping.repo;

import com.spring.onlineshopping.dto.LineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineItemRepo extends JpaRepository<LineItem, Integer> {

}
