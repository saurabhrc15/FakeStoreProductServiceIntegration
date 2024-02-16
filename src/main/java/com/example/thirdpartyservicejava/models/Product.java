package com.example.thirdpartyservicejava.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private String image;
    private String category;
    private Rating rating;
}
