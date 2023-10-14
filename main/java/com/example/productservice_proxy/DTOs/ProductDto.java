package com.example.productservice_proxy.DTOs;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDto {
    private Long Id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
    private RatingDto rating;          //Since this is another object, we will need to create a rating DTO, to prevent errors
}
