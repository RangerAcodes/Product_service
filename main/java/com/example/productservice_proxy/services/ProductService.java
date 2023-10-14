package com.example.productservice_proxy.services;

import com.example.productservice_proxy.DTOs.ProductDto;
import com.example.productservice_proxy.Models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ProductService implements iProductService {

    private RestTemplateBuilder restTemplateBuilder;
    public ProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }
    @Override
    public List<Product> getAllProducts() {
        return null;
    }
    @Override
    public String getSingleProduct(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ProductDto productDto = restTemplate.getForEntity("https://fakestoreapi.com/products", ProductDto.class).getBody();
        return productDto.toString();
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
