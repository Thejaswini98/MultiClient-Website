package com.cg.multiclient.service;

 

import java.util.List;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

 

import com.cg.multiclient.exception.ShoppingCartIdNotFoundException;
import com.cg.multiclient.model.ShoppingCart;
import com.cg.multiclient.repository.ShoppingCartRepository;

 

@Service
public class ShoppingCartService {
    
    @Autowired
    private ShoppingCartRepository cartRepository;

 

    public ShoppingCart createCart(@RequestBody ShoppingCart cart) {
        return cartRepository.save(cart);
    }

 

    /**
     * Partially update cartDetails.
     *
     * @return the persisted entity.
     */
    public ShoppingCart updateCartById(@PathVariable Long orderId,
            @RequestBody ShoppingCart order) throws ShoppingCartIdNotFoundException {
        ShoppingCart cartFound = cartRepository.findById(orderId)
                    .orElseThrow(() -> new ShoppingCartIdNotFoundException (
                            "CartIdentifier : " + orderId + " not available!!!"));
        return cartRepository.save(cartFound);
    }

 

    public List<ShoppingCart> getAllCart() {
        return (List<ShoppingCart>) cartRepository.findAll();
    }

 

    /**
     * Get cartDetails by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    public ShoppingCart findCartById(Long cartId) throws ShoppingCartIdNotFoundException  {
        ShoppingCart cartFound = cartRepository.findById(cartId)
                .orElseThrow(() -> new ShoppingCartIdNotFoundException (
                        "OrderIdentifier : " + cartId + " not available!!!"));
        return cartFound;
    }

 

    /**
     * Delete the cartDetails by id.
     *
     * @param id the id of the entity.
     */
    public void deleteCart(Long cartId) throws ShoppingCartIdNotFoundException{
        ShoppingCart cartFound = cartRepository.findById(cartId)
                .orElseThrow(() -> new ShoppingCartIdNotFoundException (
                        "OrderIdentifier : " + cartId + " not available!!!"));
        
        cartRepository.delete(cartFound);
    }

 

}