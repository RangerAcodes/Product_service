package com.example.productservice_proxy.services;

import com.example.productservice_proxy.Models.Product;
import com.example.productservice_proxy.Repositories.ProductElasticSearchRepository;
import com.example.productservice_proxy.Repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service
public class SelfProductService implements IProductService{
    ProductRepository productRepository;
    ProductElasticSearchRepository productElasticSearchRepository;


    public SelfProductService(ProductRepository productRepository, ProductElasticSearchRepository productElasticSearchRepository) {
        this.productRepository = productRepository;
        this.productElasticSearchRepository = productElasticSearchRepository;

    }
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getSingleProduct(Long productId) {
        return null;
    }

    @Override
    public Product addNewProduct(Product product) {
        this.productRepository.save(product);
        this.productElasticSearchRepository.save(product);
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
