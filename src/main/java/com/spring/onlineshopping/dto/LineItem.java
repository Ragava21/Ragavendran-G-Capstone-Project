package com.spring.onlineshopping.dto;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LineItem {
    @Id
    @GeneratedValue
    private int lineProductId;

    @ManyToOne
//    @JoinColumn(name = "lineItem_prod")


    private Product product;
    private int quantity;
    private int price;
    private int totalPrice;
    private int cartId;

    @ManyToOne
    private Cart cart;
}
