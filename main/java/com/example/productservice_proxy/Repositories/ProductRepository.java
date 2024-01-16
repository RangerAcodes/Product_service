package com.example.productservice_proxy.Repositories;

import com.example.productservice_proxy.Models.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product product); // (save) is a method of JpaRepository (interface)

    Product findProductById(Long Id);
    Product findByPriceBetween(double greaterthan, double lessthan);

    //Product findByProductName(String productName);

    // String findTitleById(Long id);

    List<Product> findByIdIsNotNullOrderByPrice();

    List<Product> findAllByIsPublicFalse();
    List<Product> findByTitleEquals(String title, Pageable pageable);
}