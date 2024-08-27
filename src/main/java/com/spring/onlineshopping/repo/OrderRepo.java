package com.spring.onlineshopping.repo;

import com.spring.onlineshopping.dao.OrderDao;
import com.spring.onlineshopping.dto.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer>, OrderDao {

}
