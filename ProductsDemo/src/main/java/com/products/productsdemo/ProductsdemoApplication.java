package com.products.productsdemo;

import com.products.productsdemo.Model.Product;
import com.products.productsdemo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductsdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductsdemoApplication.class, args);
    }

}
