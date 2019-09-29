package com.people10.ws.service;

import com.people10.ws.domain.Customer;
import com.people10.ws.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customersRepository;

    @Override
    public List<Customer> findAllCustomers() {
        return customersRepository.findAll();
    }

    @Override
    public Customer findOne(Long id) {
        return customersRepository.getOne(id);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
       return customersRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
       return customersRepository.save(customer);
    }

    @Override
    public Customer deleteCustomer(Long id) {
        Customer customer = customersRepository.getOne(id);
        customersRepository.deleteById(id);
        return customer;
    }
}
