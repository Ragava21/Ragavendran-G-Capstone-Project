package com.spring.onlineshopping.dto;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@ToString
public class LineItem1 {
    @Id
    @GeneratedValue
    private int lineProdId;

    @ManyToOne
    private Product product;
    private int orderId;
    private int quantity;
    private int price;
    private int totalPrice;





}
