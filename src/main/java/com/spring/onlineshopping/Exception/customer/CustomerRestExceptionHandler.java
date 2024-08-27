package com.spring.onlineshopping.Exception.customer;

import com.spring.onlineshopping.apierror.ApiError;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class CustomerRestExceptionHandler {
    @ExceptionHandler(value = CustomerAlreadyExistException.class)
    public ResponseEntity<ApiError> customerAlreadyExistException(CustomerAlreadyExistException ex) {
        ApiError apiError = new ApiError(400,"customer already exist",new Date());
        return new ResponseEntity<ApiError>(apiError,HttpStatus.CREATED);
    }

    @ExceptionHandler(value = CustomerNotFoundException.class)
    public ResponseEntity<ApiError> customerNotFoundException(CustomerNotFoundException ex) {
        ApiError apiError = new ApiError(400,"customer not found",new Date());
        return new ResponseEntity<ApiError>(apiError, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(value = InvalidCustomerDataException.class)
    public ResponseEntity<ApiError> invalidCustomerDataException(InvalidCustomerDataException ex) {
        ApiError apiError = new ApiError(400,"invalid customer data",new Date());
        return new ResponseEntity<>(apiError,HttpStatus.BAD_REQUEST);
    }


}
