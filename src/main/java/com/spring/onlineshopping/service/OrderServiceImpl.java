package com.spring.onlineshopping.service;

import com.spring.onlineshopping.Exception.cart.CartIsEmptyException;
import com.spring.onlineshopping.Exception.cartlineitem.CartLineItemNotFoundException;
import com.spring.onlineshopping.Exception.customer.CustomerNotFoundException;
import com.spring.onlineshopping.dto.Order;
import com.spring.onlineshopping.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepo orderRepo;
    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }


    @Override
    public void addOrder(int custId, int prodId) {
       orderRepo.addOrder(custId,prodId);
    }

//    @Override
//    public void createOrder(Order order) {
//        orderRepo.save(order);
//    }



    @Override
    public Order createOrder(Order order) {
        return orderRepo.save(order);
    }

    @Override
    public void removeOrder(int custId, int prodId) {
        orderRepo.removeOrder(custId,prodId);
    }

    @Override
    public void addOrderfromCart(int custId, int lineProdId) throws CustomerNotFoundException, CartLineItemNotFoundException, CartIsEmptyException {
        orderRepo.addOrderfromCart(custId,lineProdId);
    }

    @Override
    public void addOrderAllCart(int custId) {
        orderRepo.addOrderAllCart(custId);
    }

    @Override
    public Order displayOrder(int custId) {
        return orderRepo.displayOrder(custId);
    }
}
