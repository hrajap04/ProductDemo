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

    //insert dummy data to the DB
    @GetMapping("/dummy_data")
    public void dummyData(){
        System.out.println("data added");
        productService.addDummyProduct();
    }
    //Test
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }

    //Get the price of a given product for a given qty
    @GetMapping("/prodcut_price")
    public double getProductPrice(@RequestParam int productId, @RequestParam int qty){
        Product product = productService.getProduct(productId);
        return  productService.priceCalculation(product, qty);
    }

    //get all the products
    @GetMapping("/all_products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    //get a list of prices for a given product
    @GetMapping("/prodcut_price_list")
    public List<ItemPrice> getProductPriceList(@RequestParam int productId, @RequestParam int qty){
        return  productService.getProductPriceList(productId, qty);
    }

    //remove all the data
    @GetMapping("/remove_data")
    public String removeAllData(){
        System.out.println("data removed");
        return productService.removeAllProducts();
    }

}
