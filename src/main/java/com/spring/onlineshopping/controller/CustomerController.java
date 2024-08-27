package com.spring.onlineshopping.controller;

import com.spring.onlineshopping.Exception.customer.CustomerNotFoundException;
import com.spring.onlineshopping.dto.Customer;
import com.spring.onlineshopping.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/shop/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/custId")
    public Customer findCustomerById(@RequestParam int custId) throws CustomerNotFoundException {

       return customerService.findByCustId(custId);
    }


    @GetMapping
    public List<Customer> findAllCustomers() {
        return customerService.findAll();
    }
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.save(customer);
    }
    @PutMapping
    public Customer updateCustomer(@RequestBody Customer customer) {
        return customerService.update(customer);
    }
    @GetMapping("custName/{custName}")
    public List<Customer> findByName(@RequestParam("custName") String custName) {
        return customerService.findByCustName(custName);
    }
    @GetMapping("/city")
    public List<Customer> findByCity(@RequestParam("city") String city) {
        return customerService.findByCustCity(city);
    }
    @GetMapping("/pinCode")
    public List<Customer> findByPincode(@RequestParam("pinCode") int pinCode) {
        return customerService.findByPinCode(pinCode);

    }
    @DeleteMapping
    public void deleteCustomer(@RequestBody Customer customer) {
        customerService.delete(customer);
    }
    @PostMapping("/check")
    public void validateCustomerData(Customer customer){
        customerService.validateCustomerData(customer);
    }
}
