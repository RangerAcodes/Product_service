package com.example.productservice_proxy.Repositories;

import com.example.productservice_proxy.Models.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Categories, Long> {
     Categories save(Categories category); // (save) is a method of JpaRepository (interface)
    Categories findById(long id);

    @Query("SELECT c.name FROM Categories c WHERE c.id = :id")
    String findCategoryNameById(@Param("id") Long id);

//    @Query(value = "SELECT c.name FROM Categories c WHERE c.id = :?1")
//    String findCategoryByIdV1(long id);

    }
