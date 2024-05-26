package com.example.productservice_proxy.config;

import com.example.productservice_proxy.DTOs.ProductDto;
import com.example.productservice_proxy.Models.Product;

public class ProductConverter {
    public static ProductDto toDto(Product product) {
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setTitle(product.getTitle());
        dto.setPrice(product.getPrice());
        dto.setDescription(product.getDescription());
        dto.setCategory(product.getCategory().getName()); // Assuming Category has getName method
        dto.setImage(product.getImageUrl());
        // Convert and set RatingDto if applicable
        // dto.setRating(RatingConverter.toDto(product.getRating()));

        return dto;
    }
}
