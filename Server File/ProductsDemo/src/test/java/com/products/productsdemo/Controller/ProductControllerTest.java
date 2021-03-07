package com.products.productsdemo.Controller;

import org.apache.coyote.Request;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.RestController;

import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith(SpringExtension.class)
@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

//    @Test
//    void getProductPrice() {
//    }
//
//    @Test
//    void getAllUsers() {
//    }
//
//    @Test
//    void getProductPriceList() {
//    }

    @Test
    void sayHello() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/hello");
        MvcResult result = mockMvc.perform(request).andReturn();
        assertEquals("hello",result);

    }

//    @Test
//    void testGetProductPrice() {
//    }
//
//    @Test
//    void testGetAllUsers() {
//    }
//
//    @Test
//    void testGetProductPriceList() {
//    }
//
//    @Test
//    void dummyData() {
//    }
}