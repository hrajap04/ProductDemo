package com.products.productsdemo.Controller;

import com.products.productsdemo.Model.Product;
import com.products.productsdemo.Repository.ProductRepository;
import com.products.productsdemo.Service.ProductService;
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
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc

class ProductControllerTest {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ProductService productService;

    @Test
    void dummyData() throws  Exception{
        this.mockMvc.perform(get("/product/dummy_data")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void getProductPrice() throws Exception {
        Product product1 = new Product();
        product1.setProductName("Penguin-ears");
        product1.setCartoonSize(20);
        product1.setCartoonPrice(175.00);
        product1.setRareProduct(1);
        product1.setImageUrl("http://4.bp.blogspot.com/_W80ObqO3YRw/TP5b-gwBC_I/AAAAAAAAIq0/UALUEqXn5t0/s1600/PROFILE%2BOF%2BHEAD.JPG");
        productRepository.save(product1);

        this.mockMvc.perform(get("/product/prodcut_price?productId=1&qty=5")).andDo(print()).andExpect(status().isOk()).
                andExpect(content().string(containsString("56.88")));
    }

    @Test
    void getAllProducts() throws Exception{
        RequestBuilder request = MockMvcRequestBuilders.get("/product/all_products");
        MvcResult result = mockMvc.perform(request).andReturn();
        assertNotEquals(null,result);
    }

    @Test
    void getProductPriceList() throws Exception {
        Product product1 = new Product();
        product1.setProductName("Penguin-ears");
        product1.setCartoonSize(20);
        product1.setCartoonPrice(175.00);
        product1.setRareProduct(1);
        product1.setImageUrl("http://4.bp.blogspot.com/_W80ObqO3YRw/TP5b-gwBC_I/AAAAAAAAIq0/UALUEqXn5t0/s1600/PROFILE%2BOF%2BHEAD.JPG");
        productRepository.save(product1);

        this.mockMvc.perform(get("/product/prodcut_price_list?productId=1&qty=5")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void sayHello() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/product/hello");
        MvcResult result = mockMvc.perform(request).andReturn();
        assertEquals("Hello",result.getResponse().getContentAsString());
    }



}