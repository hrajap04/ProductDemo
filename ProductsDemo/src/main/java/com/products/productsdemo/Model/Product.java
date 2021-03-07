package com.products.productsdemo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Integer productId;

    @Column
    private String productName;

    @Column
    private Integer cartoonSize;

    @Column
    private Double cartoonPrice;

    @Column
    private Integer rareProduct;

    @Column
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }



    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getCartoonSize() {
        return cartoonSize;
    }

    public void setCartoonSize(Integer cartoonSize) {
        this.cartoonSize = cartoonSize;
    }

    public Double getCartoonPrice() {
        return cartoonPrice;
    }

    public void setCartoonPrice(Double cartoonPrice) {
        this.cartoonPrice = cartoonPrice;
    }

    public Integer getRareProduct() {
        return rareProduct;
    }

    public void setRareProduct(Integer rareProduct) {
        this.rareProduct = rareProduct;
    }


}
