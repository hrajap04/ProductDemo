package com.products.productsdemo.Controller;

import java.util.List;

import com.products.productsdemo.Class.ItemPrice;
import com.products.productsdemo.Model.Product;
import com.products.productsdemo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping( "/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/dummy_data")
    public void dummyData(){
        System.out.println("data added");
        productService.addDummyProduct();
    }
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }
//    @PostMapping("/newUser")
//    public Product saveUser(@RequestBody Product product){
//        return  productService.addProduct(product);
//    }

    @GetMapping("/prodcut_price")
    public double getProductPrice(@RequestParam int productId, @RequestParam int qty){
        Product product = productService.getProduct(productId);
        return  productService.priceCalculation(product, qty);
    }

    @GetMapping("/all_products")
    public List<Product> getAllUsers(){
        return productService.getAllProducts();
    }

    @GetMapping("/prodcut_price_list")
    public List<ItemPrice> getProductPriceList(@RequestParam int productId, @RequestParam int qty){
        return  productService.getProductPriceList(productId, qty);
    }

    @GetMapping("/remove_data")
    public String removeAllData(){
        System.out.println("data removed");
        return productService.removeAllProducts();
    }

}
