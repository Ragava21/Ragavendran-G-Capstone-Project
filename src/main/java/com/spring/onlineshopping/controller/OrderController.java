package com.spring.onlineshopping.controller;

import com.spring.onlineshopping.Exception.cartlineitem.CartLineItemNotFoundException;
import com.spring.onlineshopping.Exception.customer.CustomerNotFoundException;
import com.spring.onlineshopping.dto.Order;
import com.spring.onlineshopping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shop/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping
    public List<Order> getOrders(){
        return orderService.getAllOrders();
    }

    @PostMapping("/add_order")
    public void addOrder(@RequestParam int custId, @RequestParam int prodId){
        orderService.addOrder(custId,prodId);
    }
//    @PostMapping
//    public void createOrder(@RequestBody Order order){
//        orderService.createOrder(order);
//    }
    @PostMapping("/add")
    public void addOrder(@RequestBody Order order){
        orderService.createOrder(order);
    }

    @DeleteMapping("/removeOrder")
    public void removeOrder(@RequestParam int custId, @RequestParam int prodId){
        orderService.removeOrder(custId,prodId);
    }
    @PostMapping("/addOrder_cart")
    public void addOrderfromCart(@RequestParam int custId, @RequestParam int lineProdId) throws CustomerNotFoundException, CartLineItemNotFoundException {
        orderService.addOrderfromCart(custId,lineProdId);
    }
    @PostMapping("/addOrder_all")
    public void addOrderAllCart(@RequestParam int custId){
        orderService.addOrderAllCart(custId);
    }
    @GetMapping("/displayOrder")
    public Order displayOrder(@RequestParam int custId){
       return orderService.displayOrder(custId);
    }



}
