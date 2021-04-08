package com.cg.multiclient.repository;
import org.springframework.data.repository.CrudRepository;
import com.cg.multiclient.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
