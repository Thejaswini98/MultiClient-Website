package com.cg.multiclient.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.cg.multiclient.exception.CustomerIdNotFoundException;
import com.cg.multiclient.model.Customer;
import com.cg.multiclient.repository.CustomerRepository;

 

@Service
public class CustomerService {

 

    @Autowired
    private CustomerRepository customerRepository;

 

    public Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

 

    /**
     * Partially update a customerDetails.
     *
     * @param customerDetails the entity to update partially.
     * @return the persisted entity.
     */
    public Customer updateCustomerById(@PathVariable Long customerId,
            @RequestBody Customer customer) throws CustomerIdNotFoundException {
        Customer customerFound = customerRepository.findById(customerId)
                    .orElseThrow(() -> new CustomerIdNotFoundException (
                            "CustomerIdentifier : " + customerId + " not available!!!"));
        return customerRepository.save(customerFound);
    }

 

    public List<Customer> getAllCustomer() {
        return (List<Customer>) customerRepository.findAll();
    }

 

    /**
     * Get one customerDetails by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    public Customer findCustomerById(Long customerId) throws CustomerIdNotFoundException  {
        Customer customerFound = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerIdNotFoundException (
                        "CustomerIdentifier : " + customerId + " not available!!!"));
        return customerFound;
    }

 

    /**
     * Delete the customerDetails by id.
     *
     * @param id the id of the entity.
     */
    public void deleteCustomer(Long customerId) throws CustomerIdNotFoundException{
        Customer customerFound = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerIdNotFoundException (
                        "CustomerIdentifier : " + customerId + " not available!!!"));
        
        customerRepository.delete(customerFound);
    }
}
 