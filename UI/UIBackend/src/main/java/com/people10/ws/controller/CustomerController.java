package com.people10.ws.controller;

import com.people10.ws.domain.Customer;
import com.people10.ws.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/customers")
@Api(value="CustomerController", description = "Customer CRUD REST API",tags = "Customer Controller")
@CrossOrigin(origins = {"http://localhost:4200"},
        maxAge = 4800, allowCredentials = "false")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    @ApiOperation(value="get all customers", notes = "${CustomerController.allCustomers.notes}")
    public List<Customer> getAllCustomers() {
        return customerService.findAllCustomers();
    }
    @GetMapping("/{id}")
    @ApiOperation(value="get one customer", notes = "${CustomerController.oneCustomer.notes}")
    public Customer getCustomer(@ApiParam(value = "Customer ID to Retrieve", required = true) @PathVariable Long id) {
        return customerService.findOne(id);
    }
    @PostMapping("/")
    @ApiOperation(value="add a customer", notes = "${CustomerController.addCustomer.notes}")
    public Customer addCustomer(@ApiParam(value = "Customer JSON to Save", required = true) @RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }
    @PutMapping("/")
    @ApiOperation(value="update a customer", notes = "${CustomerController.updateCustomer.notes}")
    public Customer updateCustomer(@ApiParam(value = "Customer JSON to Update", required = true) @RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }
    @DeleteMapping("/{id}")
    @ApiOperation(value="delete a customer", notes = "${CustomerController.deleteCustomer.notes}")
    public Customer deleteCustomer(@ApiParam(value = "Customer ID to Update", required = true) @PathVariable Long id) {
        return customerService.deleteCustomer(id);
    }
}
