package com.spring.onlineshopping.repo;

import com.spring.onlineshopping.Exception.customer.CustomerNotFoundException;
import com.spring.onlineshopping.dto.Customer;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    public abstract Customer findByCustId(int custId)throws CustomerNotFoundException;
    public abstract List<Customer> findByCustName(String custName);
    public abstract List<Customer> findByCustCity(String city);
    public abstract List<Customer> findByPinCode(int pincode);


}
