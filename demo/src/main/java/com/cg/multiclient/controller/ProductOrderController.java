package com.cg.multiclient.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.multiclient.exception.OrderIdNotFoundException;
import com.cg.multiclient.model.ProductOrder;
import com.cg.multiclient.service.ProductOrderService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value = "ProductOrderController", description = "REST Api's related to Product Order Entity!!!!")
@CrossOrigin(origins = {"http://localhost:3000","http://localhost:3001"})
@RestController
@RequestMapping("/multi_client")
public class ProductOrderController {

 

    @Autowired
    private ProductOrderService orderService;
    @ApiOperation(value = "Creating specific Product Order in the System ", response = ProductOrder.class)
    @PostMapping("/order/add")
    public ProductOrder createNewCustomer(@RequestBody ProductOrder order) {
        return orderService.createOrder(order);
    }
    
    @ApiOperation(value = "Updating specific Product Order in the System ", response = ProductOrder.class)
    @PutMapping("/order/update")
    public ProductOrder updateOrder(@RequestBody ProductOrder order){
        return orderService.updateOrder(order);
    }

 
    @ApiOperation(value = "Getting all Product Orders in the System ", response = ProductOrder.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping("/order")
    public List<ProductOrder> getAllOrder() {
        return (List<ProductOrder>) orderService.getAllOrders();
    }

 
    @ApiOperation(value = "Getting specific Product Order in the System ", response = ProductOrder.class)
    @GetMapping("/order/{orderId}")
    public ProductOrder getOrderById(@PathVariable Long orderId) throws OrderIdNotFoundException{
        return orderService.findOrderById(orderId);
    }
    
    @ApiOperation(value = "Deleting specific Product Order in the System ", response = ProductOrder.class)
    @DeleteMapping("/order/delete/{orderId}")
    public void deleteOrderById(@PathVariable Long orderId) throws OrderIdNotFoundException{
        orderService.deleteOrder(orderId);
        
    }
}