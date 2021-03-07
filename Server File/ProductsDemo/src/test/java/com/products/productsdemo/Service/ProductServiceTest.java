package com.products.productsdemo.Service;

import com.products.productsdemo.Model.Product;
import com.products.productsdemo.Repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

//@DataJdbcTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductServiceTest {
    @Autowired
 private ProductService productService;
 @Autowired
    private ProductRepository productRepository;
//
//    public ProductServiceTest(ProductService productService, ProductRepository productRepositorye) {
//        this.productService = productService;
//        this.productRepositorye = productRepositorye;
//    }

    @Test
    void testTest(){
        String s = "a";
        assertEquals( "a",s   );
    }
    @Test
    void addProduct() {
        Product product1 = new Product();
        product1.setProductName("Penguin-ears");
        product1.setCartoonSize(20);
        product1.setCartoonPrice(175.00);
        product1.setRareProduct(1);
        product1.setImageUrl("http://4.bp.blogspot.com/_W80ObqO3YRw/TP5b-gwBC_I/AAAAAAAAIq0/UALUEqXn5t0/s1600/PROFILE%2BOF%2BHEAD.JPG");
        Product product = productRepository.save(product1);
        assertNotNull(product);
    }

    @Test
    void getAllProducts() {
        List<Product> product = productRepository.findAll();
        assertNotNull(product);
    }
//
//    @Test
//    void getAllProductsPageable() {
//    }
//
//    @Test
//    void getProduct(int productId) {
//        Optional<Product> productList = productRepository.findById(productId);
//        Product product = productList.get();
//    }



//    @Test
//    void addDummyProduct() {
//        Product product1 = new Product();
//        product1.setProductName("Penguin-ears");
//        product1.setCartoonSize(20);
//        product1.setCartoonPrice(175.00);
//        product1.setRareProduct(1);
//        product1.setImageUrl("http://4.bp.blogspot.com/_W80ObqO3YRw/TP5b-gwBC_I/AAAAAAAAIq0/UALUEqXn5t0/s1600/PROFILE%2BOF%2BHEAD.JPG");
//        Product product = productRepositorye.save(product1);
//        assertNotNull(product);
//
//    }

//    @Test
//    void getProductPriceList() {
//    }
//
//    @Test
//    void priceCalculation() {
//    }
}