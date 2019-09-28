package com.people10.ws.service;

import com.people10.ws.domain.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {
    List<Customer> findAllCustomers();
    Customer findOne(Long id);
    ResponseEntity<String> saveCustomer(Customer customer);
    ResponseEntity<String> updateCustomer(Customer customer);
    ResponseEntity<String> deleteCustomer(Long id);
}
