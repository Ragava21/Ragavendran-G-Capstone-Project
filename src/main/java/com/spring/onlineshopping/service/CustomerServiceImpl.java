package com.spring.onlineshopping.service;

import com.spring.onlineshopping.Exception.customer.CustomerAlreadyExistException;
import com.spring.onlineshopping.Exception.customer.CustomerNotFoundException;
import com.spring.onlineshopping.Exception.customer.InvalidCustomerDataException;
import com.spring.onlineshopping.dto.Customer;
import com.spring.onlineshopping.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
   private CustomerRepo customerRepo;

    @Override
    public Customer findByCustId(int custId) throws CustomerNotFoundException {
       Customer customer1= customerRepo.findByCustId(custId);
       if (customer1 == null){
           throw new CustomerNotFoundException();
       }
       return customer1;

    }

    @Override
    public List<Customer> findByCustName(String custName) {
       return customerRepo.findByCustName(custName);

    }

    @Override
    public List<Customer> findByCustCity(String city) {
        return customerRepo.findByCustCity(city);
    }

    @Override
    public List<Customer> findByPinCode(int pincode) {
        return customerRepo.findByPinCode(pincode);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public Customer save(Customer customer) {

        if (customerRepo.existsById(customer.getCustId())) {
            throw new CustomerAlreadyExistException();
        }
        customerRepo.save(customer);
        return customer;
    }

    @Override
    public Customer update(Customer customer) {
       return customerRepo.save(customer);

    }

    @Override
    public void delete(Customer customer) {
        customerRepo.delete(customer);

    }

    @Override
    public void validateCustomerData(Customer customer) {
        if (customer.getCustEmail() == null || !customer.getCustEmail().contains("@")) {
            throw new InvalidCustomerDataException();
        }
        if (customer.getCustName() == null || customer.getCustName().isEmpty()) {
            throw new InvalidCustomerDataException();
        }
        if(customer==null){
            throw new CustomerNotFoundException();

        }

    }
}
