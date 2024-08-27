package com.spring.onlineshopping.service;

import com.spring.onlineshopping.Exception.customer.CustomerAlreadyExistException;
import com.spring.onlineshopping.Exception.customer.CustomerNotFoundException;
import com.spring.onlineshopping.dto.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    public Customer findByCustId(int custId) throws CustomerNotFoundException;
    public List<Customer> findByCustName(String custName) throws CustomerNotFoundException;
    public List<Customer> findByCustCity(String city);
    public List<Customer> findByPinCode(int pincode);
    public List<Customer> findAll();
    public Customer save(Customer customer) throws CustomerAlreadyExistException;
    public Customer update(Customer customer);
    public void delete(Customer customer);
    public void validateCustomerData(Customer customer) throws CustomerNotFoundException; ;

}
