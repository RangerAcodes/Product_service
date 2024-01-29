package com.example.productservice_proxy.services;

import com.example.productservice_proxy.Models.Product;
import com.example.productservice_proxy.Repositories.ProductSearchRepo;
import com.example.productservice_proxy.Repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

//@Primary
//@Service
public class SelfProductService implements IProductService{

    ProductRepo productRepo;
    ProductSearchRepo productElasticSearchRepo;


    public SelfProductService(ProductRepo productRepo, ProductSearchRepo productElasticSearchRepo
        )

        {
        this.productRepo = productRepo;
        this.productElasticSearchRepo = productElasticSearchRepo;

    }
    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getSingleProduct(Long productId) {
        return null;
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
