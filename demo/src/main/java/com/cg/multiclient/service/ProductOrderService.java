package com.cg.multiclient.service;

 

import java.util.List;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

 

import com.cg.multiclient.exception.OrderIdNotFoundException;
import com.cg.multiclient.model.ProductOrder;
import com.cg.multiclient.repository.ProductOrderRepository;

 

@Service
public class ProductOrderService {

 

    @Autowired
    private ProductOrderRepository productOrderRepository;

 

    public ProductOrder createOrder(@RequestBody ProductOrder order) {
        return productOrderRepository.save(order);
    }

 

    /**
     * Partially update orderDetails.
     *
     * @return the persisted entity.
     */
    public ProductOrder updateOrder(@RequestBody ProductOrder order) {
        return productOrderRepository.save(order);
    }

 

    public List<ProductOrder> getAllOrders() {
        return (List<ProductOrder>) productOrderRepository.findAll();
    }

 

    /**
     * Get orderDetails by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    public ProductOrder findOrderById(Long orderId) throws OrderIdNotFoundException  {
        ProductOrder orderFound = productOrderRepository.findById(orderId)
                .orElseThrow(() -> new OrderIdNotFoundException (
                        "OrderIdentifier : " + orderId + " not available!!!"));
        return orderFound;
    }

 

    /**
     * Delete the orderDetails by id.
     *
     * @param id the id of the entity.
     */
    public boolean deleteOrder(Long orderId) throws OrderIdNotFoundException{
        ProductOrder orderFound = productOrderRepository.findById(orderId)
                .orElseThrow(() -> new OrderIdNotFoundException (
                        "OrderIdentifier : " + orderId + " not available!!!"));
        
        productOrderRepository.delete(orderFound);
        return true;
    }
}
 