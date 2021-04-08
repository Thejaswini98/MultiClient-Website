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

 

import com.cg.multiclient.exception.ShoppingCartIdNotFoundException;
import com.cg.multiclient.model.ShoppingCart;
import com.cg.multiclient.service.ShoppingCartService;

 

@RestController
@RequestMapping("/multi_client")
public class ShoppingCartController {

 

    @Autowired
    private ShoppingCartService cartService;
    
    @PostMapping("/cart/add")
    public ShoppingCart createNewShoppingCart(@RequestBody ShoppingCart order) {
        return cartService.createCart(order);
    }
    
    @PutMapping("/cart/update/{cartId}")
    public ShoppingCart updateCart(@PathVariable Long cartId, 
            @RequestBody ShoppingCart cart)throws ShoppingCartIdNotFoundException{
        return cartService.updateCartById(cartId, cart);
    }

 

    @GetMapping("/cart")
    public List<ShoppingCart> findAllCart() {
        return (List<ShoppingCart>) cartService.getAllCart();
    }

 

    @GetMapping("/cart/{cartId}")
    public ShoppingCart getCartById(@PathVariable Long cartId) throws ShoppingCartIdNotFoundException{
        return cartService.findCartById(cartId);
    }
    
    @DeleteMapping("/cart/delete/{cartId}")
    public void deleteCartById(@PathVariable Long cartId) throws ShoppingCartIdNotFoundException{
        cartService.deleteCart(cartId);
        
    }
}