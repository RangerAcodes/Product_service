package com.example.productservice_proxy.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity // This tells Hibernate to make a table out of this class
public class Product extends BaseModel{
    private String title;
    private double price;
    private String description;
    @ManyToOne(cascade= CascadeType.ALL)
    private Categories category;
    private String imageUrl;
}



//public class Product extends BaseModel{
//
//    private String title;
//    private double price;
//    private String description;
//
//    @OneToMany(mappedBy = "categories", cascade= CascadeType.ALL)
//    private Categories category;
//    private String imageUrl;
//
//}
