package com.spring.onlineshopping.service;

import com.spring.onlineshopping.Exception.cart.CartIsEmptyException;
import com.spring.onlineshopping.Exception.customer.CustomerNotFoundException;
import com.spring.onlineshopping.Exception.product.ProductNotFoundException;
import com.spring.onlineshopping.dto.Cart;
import com.spring.onlineshopping.dto.Customer;
import com.spring.onlineshopping.dto.LineItem;
import com.spring.onlineshopping.dto.Product;
import com.spring.onlineshopping.repo.CartRepo;
import com.spring.onlineshopping.repo.CustomerRepo;
import com.spring.onlineshopping.repo.ProductRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepo cartRepo;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CustomerRepo customerRepo;


    @Override
    public List<Cart> findAllCarts() {
        return cartRepo.findAll();
    }


    @Override
    public Cart findCartById(int id) {
        return cartRepo.findById(id).get();
    }

    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public void addProductToCart(int custId, int prodId) throws ProductNotFoundException, CustomerNotFoundException {
        Customer customer = em.find(Customer.class, custId);
        if(customer==null){
            throw new CustomerNotFoundException();
        }
        Cart cart = customer.getCart();
        if(customer==null){
            throw new CustomerNotFoundException();
        }
        if (cart != null) {
            Product p1 = em.find(Product.class, prodId);
            List<LineItem> cp = cart.getLineItems();
            boolean exist = false;
            int cpi = 0;
            for (LineItem ce : cp) {
                if (ce.getProduct() == p1) {
                    cpi = ce.getLineProductId();
                    exist = true;
                    break;
                } else {
                    throw new ProductNotFoundException("");
                }
            }
            if (exist) {
                for (LineItem cd : cp) {
                    if (cd.getLineProductId() == cpi) {
                        cd.setTotalPrice(cd.getTotalPrice() + cd.getPrice());
                        cd.setQuantity(cd.getQuantity() + 1);
                    }
                }
            } else {
                LineItem cd = new LineItem();
                cd.setCartId(cart.getCartId());
                cd.setCartId(cart.getCartId());
                cd.setProduct(p1);
                cd.setQuantity(1);
                cd.setTotalPrice(p1.getProdPrice());
                cd.setPrice(p1.getProdPrice());
                cart.getLineItems().add(cd);
                em.persist(cd);
            }
            customer.setCart(cart);
            em.persist(customer);

        } else {
            Cart cart2 = new Cart();
//            cart2.setCartId(23);
            cart2.setCustomer(customer);
            List<LineItem> cp1 = new ArrayList<>();

            cart2.setLineItems(cp1);
            Product p1 = em.find(Product.class, prodId);
            List<LineItem> cp = cart2.getLineItems();
            boolean exist = false;
            int cpi = 0;
            if (exist) {
                for (LineItem cd : cp) {
                    if (cd.getLineProductId() == cpi) {
                        cd.setTotalPrice(cd.getTotalPrice() + cd.getPrice());
                        cd.setQuantity(cd.getQuantity() + 1);
                    }

                }
            } else {
                LineItem cd = new LineItem();
                cd.setProduct(p1);
                cd.setQuantity(1);
                cd.setTotalPrice(p1.getProdPrice());
                cd.setPrice(p1.getProdPrice());
                cart2.getLineItems().add(cd);
                em.persist(cd);
            }
            em.persist(cart2);
            customer.setCart(cart2);
            em.persist(customer);
        }

    }
    @Override
    @Transactional
    public void removeProductFromCart(int custId, int prodId) {

        Customer customer = em.find(Customer.class, custId);
        if(customer==null){
            throw new CustomerNotFoundException();
        }
        Cart cart = customer.getCart();

        Product product = em.find(Product.class, prodId);
        List<LineItem> lineItems = cart.getLineItems();
        boolean exist = false;
        int tempLineProductId = 0;
        for (LineItem lineItem : lineItems) {
            if (lineItem.getProduct() == product) {
                tempLineProductId = lineItem.getLineProductId();
                exist = true;
            } else if (tempLineProductId != lineItem.getLineProductId()){
                throw new ProductNotFoundException("");
            }
            if (lineItem.getQuantity() > 1) {
                lineItem.setQuantity(lineItem.getQuantity() - 1);
                lineItem.setTotalPrice(lineItem.getTotalPrice() - lineItem.getPrice());
            } else {
                lineItems.remove(lineItem);
                break;
            }

    }
            cart.setLineItems(lineItems);
            customer.setCart(cart);
            em.persist(customer);


    }
    @Override
    public Cart saveCart(Cart cart) {
        return cartRepo.save(cart);
    }
@Transactional
    @Override
    public void removeAllFromCart(int custId) {
        Customer customer = em.find(Customer.class, custId);
        if (customer == null) {
            throw new CustomerNotFoundException();
        }

        Cart cart = customer.getCart();
        if (cart == null) {
            throw new CartIsEmptyException();
        }

        List<LineItem> lineItems = cart.getLineItems();
        if (lineItems != null && !lineItems.isEmpty()) {
            lineItems.clear();
        }
        cart.setLineItems(lineItems);
        customer.setCart(cart);
        em.merge(customer);
    }
}

