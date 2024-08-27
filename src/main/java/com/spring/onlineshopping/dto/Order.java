package com.spring.onlineshopping.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor@Getter
@Setter@ToString
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue
    private int orderId;
    private int customerId;


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<LineItem1> lineItem1List;

    private int totalPrice;


    public void setCustomer(Customer customer) {

    }
}
