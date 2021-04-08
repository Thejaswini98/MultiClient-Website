
package com.cg.multiclient.service;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import com.cg.multiclient.model.ProductOrder;
import com.cg.multiclient.repository.ProductOrderRepository;

 

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductOrderServiceTest {
    
    @MockBean
    private ProductOrderRepository productOrderRepository;
    
    @Autowired
    private ProductOrderService productOrderService;
    
    @Test
    public void testAddOrder() throws Exception {
        ProductOrder productOrder = new ProductOrder((long)1, 2, 1000.0);
        Mockito.when(productOrderRepository.save(productOrder)).thenReturn(productOrder);
        assertThat(productOrderService.createOrder(productOrder)).isEqualTo(productOrder);
    }
    
    @Test
    public void testdeleteOrder() throws Exception {
        ProductOrder productOrder = new ProductOrder((long)1,2, 1000.00);
        productOrderRepository.deleteById(productOrder.getId());
        System.out.println(productOrderRepository.findById((long) 1));
        Assert.assertTrue(productOrderRepository.findById((long) 1).isEmpty());
    }
    
    @Test
    public void testupdateOrder() throws Exception {
        ProductOrder productOrder = new ProductOrder((long)1, 2,1000.0);
        Mockito.when(productOrderRepository.save(productOrder)).thenReturn(productOrder);
        assertThat(productOrderService.updateOrder(productOrder)).isEqualTo(productOrder);
        
    }
    
    @Test
    public void testgetAllOrders() throws Exception {
        ProductOrder productOrder = new ProductOrder((long)1, 2, 1000.00);
        ProductOrder productOrder2 = new ProductOrder((long)1,3, 30000.00);
        List<ProductOrder> productList = new ArrayList<>();
        productList.add(productOrder);
        productList.add(productOrder2);

 

        Mockito.when(productOrderRepository.findAll()).thenReturn(productList);
        assertThat(productOrderService.getAllOrders()).isEqualTo(productList);

 

    }
}