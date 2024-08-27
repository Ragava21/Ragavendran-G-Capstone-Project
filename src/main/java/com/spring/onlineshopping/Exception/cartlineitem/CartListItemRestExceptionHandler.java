package com.spring.onlineshopping.Exception.cartlineitem;

import com.spring.onlineshopping.apierror.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class CartListItemRestExceptionHandler {
    @ExceptionHandler(value = CartLineItemNotFoundException.class)
    public ResponseEntity<ApiError> handleCartLineItemNotFoundException(CartLineItemNotFoundException ex) {
        ApiError apiError = new ApiError(400,"cartlineitem not found",new Date());
        return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
    }
}
