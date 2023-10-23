package com.example.productservice_proxy.Repositories;

import com.example.productservice_proxy.Models.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Categories, Long> {
     Categories save(Categories category); // (save) is a method of JpaRepository (interface)
    Categories findById(long id);

    }
