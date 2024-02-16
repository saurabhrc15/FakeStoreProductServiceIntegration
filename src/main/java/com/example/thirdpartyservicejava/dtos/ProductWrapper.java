package com.example.thirdpartyservicejava.dtos;

import com.example.thirdpartyservicejava.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductWrapper {
    private String message;
    private Product product;

    public ProductWrapper(String message, Product product) {
        this.message = message;
        this.product = product;
    }
}
