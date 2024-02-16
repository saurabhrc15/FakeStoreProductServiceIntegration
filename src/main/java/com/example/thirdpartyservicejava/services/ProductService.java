package com.example.thirdpartyservicejava.services;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.thirdpartyservicejava.dtos.ProductRequestDto;
import com.example.thirdpartyservicejava.exceptions.NoSuchProductFoundException;
import com.example.thirdpartyservicejava.models.Product;
import org.springframework.stereotype.Service;
@Service
public interface ProductService {
    public Product getProductById(Long id) throws NoSuchProductFoundException;
    public List<Product> getProducts(Map<String, String> allParams);
    public Product addNewProduct(ProductRequestDto productRequestDto);
    public Product updateProduct(Long id, ProductRequestDto productRequestDto);
}
