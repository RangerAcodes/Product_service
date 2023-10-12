package com.example.productservice_proxy.Models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel{

    private String title;
    private double price;

    private String description;

    private Categories categories;

    private String imageURL;

    private String imageURL2;

}
