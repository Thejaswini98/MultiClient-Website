package com.cg.multiclient.repository;

import org.springframework.data.repository.CrudRepository;
import com.cg.multiclient.model.ProductOrder;

public interface ProductOrderRepository extends CrudRepository<ProductOrder, Long>{

}
