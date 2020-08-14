package com.thoughtworks.rslist.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.rslist.domain.Order;
import com.thoughtworks.rslist.domain.Product;
import com.thoughtworks.rslist.entity.OrderEntity;
import com.thoughtworks.rslist.entity.ProductEntity;
import com.thoughtworks.rslist.repository.OrderRepository;
import com.thoughtworks.rslist.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    OrderRepository orderRepository;

    @BeforeEach
    void cleanUp(){
        orderRepository.deleteAll();
    }

    @Test
    void getOrderList() throws Exception{
        OrderEntity orderEntity = OrderEntity.builder().orderName("可乐").orderPrice(5).orderUnit("瓶").number(10).build();
        orderRepository.save(orderEntity);
        mockMvc.perform(get("/order"))
                .andExpect(jsonPath("$[0].orderName",is("可乐")))
                .andExpect(jsonPath("$[0].orderPrice",is(5)))
                .andExpect(jsonPath("$[0].orderUnit",is("瓶")))
                .andExpect(jsonPath("$[0].number",is(10)))
                .andExpect(status().isOk());
    }

}