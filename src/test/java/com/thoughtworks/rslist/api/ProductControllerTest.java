package com.thoughtworks.rslist.api;

import com.thoughtworks.rslist.entity.ProductEntity;
import com.thoughtworks.rslist.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ProductRepository productRepository;

    @BeforeEach
    void cleanUp(){
        productRepository.deleteAll();
    }

    @Test
    void getProductList() throws Exception{
        ProductEntity productEntity = ProductEntity.builder().proName("可乐").price(5).unit("瓶").url("/img").build();
        productRepository.save(productEntity);
        mockMvc.perform(get("/product"))
                .andExpect(jsonPath("$[0].proName",is("可乐")))
                .andExpect(jsonPath("$[0].price",is(5)))
                .andExpect(jsonPath("$[0].unit",is("瓶")))
                .andExpect(jsonPath("$[0].url",is("/img")))
                .andExpect(status().isOk());
    }
}