package com.spring.onlineshopping.service;

import com.spring.onlineshopping.Exception.cart.CartIsEmptyException;
import com.spring.onlineshopping.Exception.customer.CustomerNotFoundException;
import com.spring.onlineshopping.Exception.product.ProductNotFoundException;
import com.spring.onlineshopping.dto.Cart;

import java.util.List;

public interface CartService {
    public List<Cart> findAllCarts();
    public Cart findCartById(int id);
    public void addProductToCart(int customerId, int productId)throws ProductNotFoundException, CustomerNotFoundException;
    public void removeProductFromCart(int custId,int prodId)throws ProductNotFoundException, CustomerNotFoundException;
    public Cart saveCart(Cart cart);
    public void removeAllFromCart(int custId)throws CustomerNotFoundException, CartIsEmptyException;
}
