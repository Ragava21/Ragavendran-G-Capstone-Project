package com.spring.onlineshopping.service;

import com.spring.onlineshopping.Exception.cart.CartIsEmptyException;
import com.spring.onlineshopping.Exception.cartlineitem.CartLineItemNotFoundException;
import com.spring.onlineshopping.Exception.customer.CustomerNotFoundException;
import com.spring.onlineshopping.Exception.product.ProductNotFoundException;
import com.spring.onlineshopping.dto.Order;

import java.util.List;

public interface OrderService {
    public void addOrder(int custId,int prodId)throws CustomerNotFoundException, ProductNotFoundException;
    //public void createOrder(Order order);
    public List<Order> getAllOrders();
    public Order createOrder(Order order);
    public void removeOrder(int custId, int prodId);
    public void addOrderfromCart(int custId, int lineProdId) throws CustomerNotFoundException, CartLineItemNotFoundException, CartIsEmptyException;
    public void addOrderAllCart(int custId)throws CustomerNotFoundException,CartIsEmptyException;
    public Order displayOrder(int custId);
}
