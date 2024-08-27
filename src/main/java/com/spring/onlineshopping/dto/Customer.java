package com.spring.onlineshopping.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.engine.internal.Cascade;

import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {
    @Id
    private int custId;
    private String custName;
    private String custCity;
    private int pinCode;
    private String custEmail;
   @OneToOne
   @JoinColumn(name = "customer_cart")
   @JsonManagedReference
   private Cart cart;

     @OneToOne(cascade = CascadeType.ALL)
     private Order order;



}
