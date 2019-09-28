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
    public ResponseEntity<String> saveCustomer(Customer customer) {
       customersRepository.save(customer);
       return new ResponseEntity <>("Customer with first name " +customer.getFirst_name()+" has been created", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> updateCustomer(Customer customer) {
        customersRepository.save(customer);
        return new ResponseEntity <>("Customer with first name " +customer.getFirst_name()+" has been updated", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteCustomer(Long id) {
        customersRepository.deleteById(id);
        return new ResponseEntity <>("Customer with id " +id+" has been deleted", HttpStatus.OK);
    }
}
