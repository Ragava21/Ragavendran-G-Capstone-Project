package com.spring.onlineshopping.dao;

import com.spring.onlineshopping.Exception.cart.CartIsEmptyException;
import com.spring.onlineshopping.Exception.cartlineitem.CartLineItemNotFoundException;
import com.spring.onlineshopping.Exception.customer.CustomerNotFoundException;
import com.spring.onlineshopping.Exception.product.ProductNotFoundException;
import com.spring.onlineshopping.dto.Order;

public interface OrderDao {
    public void addOrder(int custId,int prodId)throws CustomerNotFoundException, ProductNotFoundException;
    public void removeOrder(int custId,int prodId)throws CustomerNotFoundException, ProductNotFoundException;
    public void addOrderfromCart(int custId,int lineProdId) throws CustomerNotFoundException, CartLineItemNotFoundException, CartIsEmptyException;
    public void addOrderAllCart(int custId)throws CustomerNotFoundException,CartIsEmptyException;
    public Order displayOrder(int custId);
}
