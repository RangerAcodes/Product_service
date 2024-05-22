package com.example.productservice_proxy.services;

import com.example.productservice_proxy.DTOs.ProductDto;
import com.example.productservice_proxy.Models.Product;
import com.example.productservice_proxy.ElasticsearchRepo.ProductElasticSearchRepo;
import com.example.productservice_proxy.Repositories.ProductRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;

import java.util.List;
import java.util.Optional;

@Primary
@Service
public class SelfProductService implements IProductService {

    private final RestTemplateBuilder restTemplateBuilder;
    ProductRepo productRepo;


    ProductElasticSearchRepo productElasticSearchRepo;

    public SelfProductService(ProductRepo productRepo,
                              ProductElasticSearchRepo productElasticSearchRepo,
                              RestTemplateBuilder restTemplateBuilder) {
        this.productRepo = productRepo;
        this.productElasticSearchRepo = productElasticSearchRepo;
        this.restTemplateBuilder = restTemplateBuilder;
    }
    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product getSingleProduct(Long productId) {

        Optional<Product> product = productRepo.findById(productId);
        if(product.isEmpty()) {
            throw new EntityNotFoundException("ProductNot Found");
        }
        return product.get();

    }

    @Override
    public Product addNewProduct(Product product) {
        this.productRepo.save(product);
        this.productElasticSearchRepo.save(product);
        return product;
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public String deleteProduct(Long productId) {
        return null;
    }
}