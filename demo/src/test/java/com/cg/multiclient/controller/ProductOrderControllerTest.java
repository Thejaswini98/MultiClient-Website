package com.cg.multiclient.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.cg.multiclient.model.ProductOrder;
import com.cg.multiclient.service.ProductOrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ProductOrderController.class)
public class ProductOrderControllerTest {

 

    @Autowired
    MockMvc mockMvc;
    
    @MockBean
    private ProductOrderService productOrderService;
    
    @Test
    public void testAddOrder() throws Exception {

 

        ProductOrder productOrder = new ProductOrder((long)1, 2, 1000.0);
    	String jsonInput = this.converttoJson(productOrder);
        Mockito.when(productOrderService.createOrder(Mockito.any(ProductOrder.class))).thenReturn(productOrder);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/multi_client/order/add")
                .accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertThat(jsonInput).isEqualTo(jsonOutput);
        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
    }
    @Test
    public void testgetAllOrders() throws Exception {

 

        ProductOrder productOrder = new ProductOrder((long)2,2, 25000.00);
        ProductOrder productOrder2 = new ProductOrder((long)1,5,30000.00);
        List<ProductOrder> productList = new ArrayList<>();
        productList.add(productOrder);
        productList.add(productOrder2);

 

        String jsonInput = this.converttoJson(productList);
        Mockito.when(productOrderService.getAllOrders()).thenReturn(productList);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/multi_client/order")
                .accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();

 

        assertThat(jsonInput).isEqualTo(jsonOutput);

 

    }

    @Test
    public void testUpdateOrder() throws Exception {
        ProductOrder productOrder = new ProductOrder((long)1,4,60000.0);
        String jsonInput = this.converttoJson(productOrder);

 

        Mockito.when(productOrderService.updateOrder(Mockito.any(ProductOrder.class)))
                .thenReturn(productOrder);
        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders.put("/multi_client/order/update")
                        .accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertThat(jsonInput).isEqualTo(jsonOutput);
        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());

 

    }

    
    @Test
    public void testDeleteOrder() throws Exception {
        ProductOrder productOrder = new ProductOrder((long)2, 8, 30000.00);
        productOrderService.deleteOrder(productOrder.getId());
        assertThat(productOrderService.deleteOrder((long)2)).isFalse();
    }
    
    private String converttoJson(Object productOrder) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(productOrder);
    }
}