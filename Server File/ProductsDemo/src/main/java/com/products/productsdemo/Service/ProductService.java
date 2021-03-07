package com.products.productsdemo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.products.productsdemo.Class.ItemPrice;
import com.products.productsdemo.Model.Product;
import com.products.productsdemo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


@Service
public class ProductService {


    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //get all the products
    public List<Product> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        return productList;
    }
    public Page<Product> getAllProductsPageable(int pageNumber, int pageSize)  {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        return productRepository.findAll(page);
    }

    //get product by id
    public Product getProduct(int productId) {
        Optional<Product>productList = productRepository.findById(productId);
        Product product = productList.get();
        return product;
    }

    //add products
    public Product addProduct(Product product){
        Product addedProduct = productRepository.save(product);
        return addedProduct;
    }

    //add dummy data
    public void addDummyProduct(){
        Product product1 = new Product();
        product1.setProductName("Penguin-ears");
        product1.setCartoonSize(20);
        product1.setCartoonPrice(175.00);
        product1.setRareProduct(1);
        product1.setImageUrl("http://4.bp.blogspot.com/_W80ObqO3YRw/TP5b-gwBC_I/AAAAAAAAIq0/UALUEqXn5t0/s1600/PROFILE%2BOF%2BHEAD.JPG");
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setProductName("Horseshoe");
        product2.setCartoonSize(5);
        product2.setCartoonPrice(825.00);
        product2.setRareProduct(1);
        product2.setImageUrl("https://www.sellingantiques.co.uk/photosnew/dealer_Theantiquesboutique/dealer_Theantiquesboutique_highres_1579275283152-7123455232.jpg");
        productRepository.save(product2);

    }

    //get list of product items
    public List<ItemPrice> getProductPriceList(int productId, int qty) {
        List<ItemPrice> itemPriceList = new ArrayList<>();
        ItemPrice iPrice ;
        Product product = this.getProduct(productId);
        if (qty > 0) {
            for (int i = 1; i < qty + 1; i++) {
                iPrice =  new ItemPrice();
                iPrice.setItemCount(i);
                iPrice.setPrice(this.priceCalculation(product, i));
                itemPriceList.add(iPrice);
            }
        }

        return itemPriceList;
    }


    //price calculation
    public double priceCalculation(Product product,int qty){

        final double cartoonDiscount = 0.9;
        final double manualLabourCharge = 1.3;
        int cartoonCount;
        int singleUnits;
        double totalAmount = 0.0;

        if (qty>0){
            try {
                cartoonCount = qty / product.getCartoonSize() ;
                singleUnits = qty % product.getCartoonSize() ;

                //calculate cartoon price total
                if (cartoonCount>0){
                    if (cartoonCount>2){
                        totalAmount = (cartoonCount * cartoonDiscount * product.getCartoonPrice());
                    }
                    else{
                        totalAmount =  (cartoonCount * product.getCartoonPrice());
                    }
                }
                //calculate single units price total
                if (singleUnits>0){
                    totalAmount = totalAmount + (singleUnits * manualLabourCharge * (product.getCartoonPrice()/ product.getCartoonSize()));
                }
                //rounding
                if (totalAmount>0){
                    totalAmount = (double) Math.round(totalAmount * 100) / 100;
                }
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return  totalAmount;
    }

    //remove all the products
    public String removeAllProducts() {
        productRepository.deleteAll();
        return "Data Deleted";
    }

}
