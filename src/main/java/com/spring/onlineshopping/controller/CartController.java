package com.spring.onlineshopping.controller;

import com.spring.onlineshopping.dto.Cart;
import com.spring.onlineshopping.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
//import com.spring.onlineshopping.dto.Cart.CartItem;

@RestController
@RequestMapping("/api/shop/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping
    public List<Cart> getAllCart(){
        return cartService.findAllCarts();
    }

    @PostMapping("/add_cart")
    public void addProductToCart( @RequestParam int custId,
                                  @RequestParam int prodId
                                  )  {
         cartService.addProductToCart(custId, prodId);

    }
    @PostMapping
    public Cart save(@RequestBody Cart cart){
        return cartService.saveCart(cart);
    }

    @DeleteMapping("/removeProd")
    public void removeProductFromCart(@RequestParam int custId,@RequestParam int prodId) {
        cartService.removeProductFromCart(custId, prodId);
    }

    @GetMapping("/{cartId}")
    public Cart getCartById(@PathVariable int cartId){
        return cartService.findCartById(cartId);
    }
    @DeleteMapping("/removeAll")
    public void removeAllProductFromCart(@RequestParam int custId) {
        cartService.removeAllFromCart(custId);
    }









//    @PostMapping
//    public Cart addCart(int cartId, Cart.CartItem item) {
//        return cartService.addItemToCart(cartId, item);
//
//    }
//    @PutMapping
//    public Cart updateItemInCart(int cartId, Cart.CartItem updatedItem) {
//        return cartService.updateItemInCart(cartId, updatedItem);
//    }
//    @DeleteMapping
//    public Cart removeItemFromCart(int cartId, String prodName) {
//        return cartService.removeItemFromCart(cartId, prodName);
//    }
}
