package com.people10.ws.service;

import com.people10.ws.domain.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {
    List<Customer> findAllCustomers();
    Customer findOne(Long id);
    Customer saveCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    Customer deleteCustomer(Long id);
}
