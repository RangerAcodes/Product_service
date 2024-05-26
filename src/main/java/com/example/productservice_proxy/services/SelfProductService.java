package com.example.productservice_proxy.services;

import com.example.productservice_proxy.DTOs.ProductDto;
import com.example.productservice_proxy.Models.Product;
import com.example.productservice_proxy.ElasticsearchRepo.ProductElasticSearchRepo;
import com.example.productservice_proxy.Repositories.ProductRepo;
import com.example.productservice_proxy.config.ProductConverter;
import jakarta.annotation.Nullable;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.slf4j.Logger;


import java.util.List;
import java.util.Optional;


@Primary
@Service
public class SelfProductService implements IProductService {

    private final RestTemplateBuilder restTemplateBuilder;
    FakeStoreProductService fakeStoreProductService;
    ProductRepo productRepo;
    ProductDto productDto;
    private static final Logger logger = (Logger) LoggerFactory.getLogger(SelfProductService.class);

    ProductElasticSearchRepo productElasticSearchRepo;

    public SelfProductService(ProductRepo productRepo,
                              ProductElasticSearchRepo productElasticSearchRepo,
                              RestTemplateBuilder restTemplateBuilder,
                              FakeStoreProductService fakeStoreProductService
                             ) {
        this.productRepo = productRepo;
        this.productElasticSearchRepo = productElasticSearchRepo;
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreProductService = fakeStoreProductService;
    }


    private <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url, @Nullable Object request,
                                                   Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.requestFactory(
                HttpComponentsClientHttpRequestFactory.class
        ).build();
        RequestCallback requestCallback =restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }


    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        logger.debug("Fetching product with ID:{}", productId);

        Optional<Product> product = productRepo.findById(productId);
        if(product.isEmpty()) {
            logger.warn("Product with ID: {} not found", productId);
            throw new EntityNotFoundException("Product Not Found");
        }
        logger.debug("Product with ID: {} found", productId);
        return product.get();
        //return fakeStoreProductService.getProduct(ProductDto);
        //Product.toDto(product);
        //return ProductConverter.toDto(product);
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