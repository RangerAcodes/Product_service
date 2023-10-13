package com.example.productservice_proxy.services;

import com.example.productservice_proxy.DTOs.ProductDto;
import com.example.productservice_proxy.Models.Product;

import java.util.List;

public class ProductService implements iProductService {


    @Override
    public List<Product> getAllProducts() {
        return null;
    }
    @Override
    public Product getSingleProduct(Long productId) {
        return null;
    }
    @Override
    public Product addNewProduct(ProductDto productDto) {
        return null;
    }

    @Override
    public String updateProduct(Long productId) {
        return null;
    }
    @Override
    public String deleteProduct(Long productId) {
        return null;
    }



}
