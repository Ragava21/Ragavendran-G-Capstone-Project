package com.spring.onlineshopping.dao;

import com.spring.onlineshopping.Exception.cart.CartIsEmptyException;
import com.spring.onlineshopping.Exception.cartlineitem.CartLineItemNotFoundException;
import com.spring.onlineshopping.Exception.customer.CustomerNotFoundException;
import com.spring.onlineshopping.Exception.product.ProductNotFoundException;
import com.spring.onlineshopping.dto.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public void removeOrder(int custId,int prodId)throws CustomerNotFoundException, ProductNotFoundException {
        Customer customer = em.find(Customer.class, custId);
        if (customer == null) {
            throw new CustomerNotFoundException();
        }
//       Product product=em.find(Product.class,pro);
        Product product = em.find(Product.class, prodId);
        if (product == null) {
            throw new ProductNotFoundException("Product not found");
        }
        Order order = customer.getOrder();
        List<LineItem1> lineitems = order.getLineItem1List();
        //boolean exist = false;
        for (LineItem1 lineItem : lineitems) {
//            lineItem.setLineProdId(product.getProdId());

            if (lineItem.getProduct().getProdId() == product.getProdId()) {
                if(lineItem.getQuantity()>1) {
                    lineItem.setQuantity(lineItem.getQuantity() - 1);
                    lineItem.setPrice(lineItem.getPrice() - product.getProdPrice());
                }
                else{
                    lineitems.remove(lineItem);
                }
            break;

            }
        }
        order.setTotalPrice((int)(order.getTotalPrice()- product.getProdPrice()));
        em.persist(order);
        order.setLineItem1List(lineitems);
        customer.setOrder(order);
        em.persist(customer);
    }

    @Override
    @Transactional
    public void addOrderfromCart(int custId, int lineProdId) throws CustomerNotFoundException,CartLineItemNotFoundException {
        Customer customer = em.find(Customer.class, custId);
        LineItem lineItem = em.find(LineItem.class, lineProdId);

        if (customer == null)  {
            throw new CustomerNotFoundException();
        }
        if (lineItem == null)  {
            throw new CartLineItemNotFoundException();
        }
        Order order = customer.getOrder();
        if (order == null) {
            order = new Order();
            order.setCustomer(customer);
            order.setTotalPrice(order.getTotalPrice());
            order.setLineItem1List(new ArrayList<>());
        }
        LineItem1 lineItem1 = new LineItem1();
        lineItem1.setProduct(lineItem.getProduct());
        lineItem1.setQuantity(lineItem.getQuantity());
        lineItem1.setPrice(lineItem.getPrice());
        lineItem1.setTotalPrice(lineItem1.getQuantity() * lineItem1.getPrice());
        order.getLineItem1List().add(lineItem1);
        order.setTotalPrice(order.getTotalPrice() + lineItem1.getTotalPrice());
        if (order.getOrderId() >=0) {
            em.persist(order);
        } else {
            em.merge(order);
        }
        customer.setOrder(order);
        em.merge(customer);
        Cart cart = customer.getCart();
        if (cart == null) {
            throw new CartIsEmptyException();
        }
        List<LineItem> lineItems = cart.getLineItems();
        lineItems.remove(lineItem);
        cart.setLineItems(lineItems);
        em.merge(cart);
        Product product = lineItem.getProduct();
        product.setProdQuantity(product.getProdQuantity() - lineItem.getQuantity());
        em.merge(product);
    }


    @Override
    @Transactional
    public void addOrderAllCart(int custId) throws CustomerNotFoundException{
        Customer customer = em.find(Customer.class, custId);
        if (customer == null) {
            throw new CustomerNotFoundException();
        }
        Cart cart = customer.getCart();
        if (cart == null || cart.getLineItems().isEmpty()) {
            throw new CartIsEmptyException();
        }
        Order order = customer.getOrder();
        if (order == null) {
            order = new Order();
            order.setCustomer(customer);
            order.setTotalPrice(order.getTotalPrice());
            order.setLineItem1List(new ArrayList<>());
            em.persist(order);
        }
        for (LineItem lineItem : cart.getLineItems()) {
            LineItem1 lineItem1 = new LineItem1();
            lineItem1.setProduct(lineItem.getProduct());
            lineItem1.setQuantity(lineItem.getQuantity());
            lineItem1.setPrice(lineItem.getPrice());
            lineItem1.setTotalPrice(lineItem.getQuantity() * lineItem.getPrice());
            order.setTotalPrice(order.getTotalPrice() + lineItem1.getTotalPrice());
            order.getLineItem1List().add(lineItem1);
            Product product = lineItem.getProduct();
            product.setProdQuantity(product.getProdQuantity() - lineItem.getQuantity());
            em.merge(product);
        }
        cart.getLineItems().clear();
        em.merge(cart);
        customer.setOrder(order);
        em.merge(customer);



    }

    @Override
    @Transactional
    public Order displayOrder(int custId) {
        Customer customer=em.find(Customer.class,custId);
        return customer.getOrder();
    }

    @Override
    @Transactional
    public void addOrder(int custId, int prodId) throws CustomerNotFoundException, ProductNotFoundException {
        Customer customer = em.find(Customer.class, custId);
        Product product = em.find(Product.class, prodId);

        if (customer == null) {
            throw new CustomerNotFoundException();
        }
        if (product == null)  {
            throw new ProductNotFoundException("Product not found");
        }
        Order order = customer.getOrder();
        if (order == null) {
            order = new Order();
            order.setCustomer(customer);
            List<LineItem1> lineItemList = new ArrayList<>();
            LineItem1 lineItem1 = new LineItem1();
            lineItem1.setProduct(product);
            lineItem1.setQuantity(1);
            lineItem1.setPrice(product.getProdPrice());
            lineItem1.setTotalPrice(product.getProdPrice());

            lineItemList.add(lineItem1);
            order.setLineItem1List(lineItemList);
            order.setTotalPrice(product.getProdPrice());


            em.persist(lineItem1);
            em.persist(order);


            customer.setOrder(order);
            em.merge(customer);
        } else {

            List<LineItem1> lineItemList = order.getLineItem1List();
            if (lineItemList == null) {
                lineItemList = new ArrayList<>();
                order.setLineItem1List(lineItemList);
            }

            boolean itemExists = false;

            if (!itemExists) {
                LineItem1 newLineItem = new LineItem1();
                newLineItem.setProduct(product);
                newLineItem.setQuantity(1);
                newLineItem.setPrice(product.getProdPrice());
                newLineItem.setTotalPrice(product.getProdPrice());
                lineItemList.add(newLineItem);
                em.persist(newLineItem);
            }

            int totalPrice = 0;
            for (LineItem1 lineItem : lineItemList) {
                totalPrice += lineItem.getTotalPrice();
            }
            order.setTotalPrice(totalPrice);
            em.persist(order);
        }
        product.setProdQuantity(product.getProdQuantity() - 1);
        em.persist(product);
    }





}




