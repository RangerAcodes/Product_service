package com.example.productservice_proxy.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@Entity // This tells Hibernate to make a table out of this class
@Document(indexName = "productservice")
public class Product extends BaseModel{
    private String title;
    private double price;
    private String description;
    @ManyToOne(cascade= CascadeType.ALL)
    private Categories category;
    private String imageUrl;
    private Boolean isPublic;
    private int numberOfUnits;
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
