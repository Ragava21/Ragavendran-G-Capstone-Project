package com.spring.onlineshopping.dto;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter@Getter
@ToString
public class Product {
    @Id
    private int prodId;
    private String prodName;
    private int prodPrice;
    private String prodCategory;
    private int prodQuantity;
    //private int totalPrice;



//    public Product() {
//    }
//
//    public Product(int prodId, String prodName, int prodPrice, String prodCategory) {
//        this.prodId = prodId;
//        this.prodName = prodName;
//        this.prodPrice = prodPrice;
//        this.prodCategory = prodCategory;
//    }
//
//    public int getProdId() {
//        return prodId;
//    }
//
//    public void setProdId(int prodId) {
//        this.prodId = prodId;
//    }
//
//    public String getProdName() {
//        return prodName;
//    }
//
//    public void setProdName(String prodName) {
//        this.prodName = prodName;
//    }
//
//    public int getProdPrice() {
//        return prodPrice;
//    }
//
//    public void setProdPrice(int prodPrice) {
//        this.prodPrice = prodPrice;
//    }
//
//    public String getProdCategory() {
//        return prodCategory;
//    }
//
//    public void setProdCategory(String prodCategory) {
//        this.prodCategory = prodCategory;
//    }
//
//    @Override
//    public String toString() {
//        return "Product{" +
//                "prodId=" + prodId +
//                ", prodName='" + prodName + '\'' +
//                ", prodPrice=" + prodPrice +
//                ", prodCategory='" + prodCategory + '\'' +
//                '}';
//    }
//
//
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(prodId, prodName, prodPrice, prodCategory);
//    }


}
