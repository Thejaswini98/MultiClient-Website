package com.cg.multiclient.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 

import com.cg.multiclient.exception.CustomerIdNotFoundException;
import com.cg.multiclient.model.Customer;
import com.cg.multiclient.service.CustomerService;

 

@RestController
@RequestMapping("/multiclient")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;
    
    @PostMapping("/customer/add")
    public Customer createNewCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }
    
    @PutMapping("/customer/update/{customerId}")
    public Customer updateCustomer(@PathVariable Long customerId, 
            @RequestBody Customer customer)throws CustomerIdNotFoundException{
        return customerService.updateCustomerById(customerId, customer);
    }

 

    @GetMapping("/customer")
    public List<Customer> getAllCustomer() {
        return (List<Customer>) customerService.getAllCustomer();
    }

 

    @GetMapping("/customer/{customerId}")
    public Customer getCustomerById(@PathVariable Long customerId) throws CustomerIdNotFoundException{
        return customerService.findCustomerById(customerId);
    }
    
    @DeleteMapping("/customer/delete/{customerId}")
    public void deleteCustomerById(@PathVariable Long customerId) throws CustomerIdNotFoundException{
        customerService.deleteCustomer(customerId);
        
    }
}