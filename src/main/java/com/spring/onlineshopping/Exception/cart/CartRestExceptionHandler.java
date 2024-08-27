package com.spring.onlineshopping.Exception.cart;

import com.spring.onlineshopping.apierror.ApiError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class CartRestExceptionHandler {
    @ExceptionHandler(value = CartIsEmptyException.class)
    public ResponseEntity<ApiError> handleCartIsEmptyException(CartIsEmptyException ex) {
        ApiError apiError = new ApiError(400,"cart is empty",new Date());
        return new ResponseEntity<ApiError>(apiError, HttpStatus.BAD_REQUEST);
    }
}
