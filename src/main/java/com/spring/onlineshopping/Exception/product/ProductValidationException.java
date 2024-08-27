package com.spring.onlineshopping.Exception.product;

import lombok.*;

import java.util.Date;
@NoArgsConstructor
//@AllArgsConstructor
@Getter@Setter
@ToString
public class ProductValidationException {
    private int errorCode;
    private String errorMessage;
    private Date errorDate;
    public ProductValidationException(int errorCode, String errorMessage, Date date) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorDate = date;
    }
}
