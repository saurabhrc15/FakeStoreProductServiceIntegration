package com.example.thirdpartyservicejava.controllers;

import com.example.thirdpartyservicejava.dtos.ProductListWrapper;
import com.example.thirdpartyservicejava.dtos.ProductRequestDto;
import com.example.thirdpartyservicejava.dtos.ProductWrapper;
import com.example.thirdpartyservicejava.exceptions.NoSuchProductFoundException;
import com.example.thirdpartyservicejava.models.Product;
import com.example.thirdpartyservicejava.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<ProductListWrapper> getProducts(@RequestParam Map<String, String> allParams) {
        ResponseEntity<ProductListWrapper> response;

        try {
            List<Product> productList = productService.getProducts(allParams);
            ProductListWrapper productListWrapper = new ProductListWrapper("Success", productList);
            response = new ResponseEntity<>(productListWrapper, HttpStatus.OK);
        } catch (RuntimeException e) {
            ProductListWrapper productListWrapper = new ProductListWrapper(e.getMessage(), null);
            response = new ResponseEntity<>(productListWrapper, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return response;
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductWrapper> getProduct(@PathVariable("id") Long id) {
        ResponseEntity<ProductWrapper> response;

        try {
            Product product = productService.getProductById(id);
            ProductWrapper productWrapper = new ProductWrapper("Success", product);
            response = new ResponseEntity<>(productWrapper, HttpStatus.OK);
        } catch (NoSuchProductFoundException e) {
            ProductWrapper productWrapper = new ProductWrapper("Failure : No product found with id : " + id, null);
            response = new ResponseEntity<>(productWrapper, HttpStatus.OK);
        }

        return response;
    }

    @PostMapping("/product")
    public ResponseEntity<ProductWrapper> addNewProduct(@RequestBody ProductRequestDto productRequestDto) {
        ResponseEntity<ProductWrapper> response;

        try {
            Product product = productService.addNewProduct(productRequestDto);
            ProductWrapper productWrapper = new ProductWrapper("Success", product);
            response = new ResponseEntity<>(productWrapper, HttpStatus.OK);
        } catch (RuntimeException e) {
            ProductWrapper productWrapper = new ProductWrapper("Failure : Unable to add new product", null);
            response = new ResponseEntity<>(productWrapper, HttpStatus.OK);
        }

        return response;
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ProductWrapper> updateProduct(@PathVariable("id") Long id, @RequestBody ProductRequestDto productRequestDto) {
        ResponseEntity<ProductWrapper> response;

        try {
            Product product = productService.updateProduct(id, productRequestDto);
            ProductWrapper productWrapper = new ProductWrapper("Success", product);
            response = new ResponseEntity<>(productWrapper, HttpStatus.OK);
        } catch (RuntimeException e) {
            ProductWrapper productWrapper = new ProductWrapper("Failure : Unable to update product for id : " + id, null);
            response = new ResponseEntity<>(productWrapper, HttpStatus.OK);
        }

        return response;
    }
}
