package com.example.thirdpartyservicejava.dtos;

import com.example.thirdpartyservicejava.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductListWrapper {
    private String message;
    private List<Product> products;

    public ProductListWrapper(String message, List<Product> products) {
        this.message = message;
        this.products = products;
    }
}
