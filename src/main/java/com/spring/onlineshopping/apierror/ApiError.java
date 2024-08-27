package com.spring.onlineshopping.apierror;

import lombok.*;

import javax.xml.crypto.Data;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ApiError {
    private Integer errorCode;
    private String errorMessage;
    private Date date;
}
