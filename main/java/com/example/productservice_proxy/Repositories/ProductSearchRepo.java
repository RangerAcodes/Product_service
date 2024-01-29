package com.example.productservice_proxy.Repositories;

import com.example.productservice_proxy.Models.Product;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductSearchRepo extends ElasticsearchRepository<Product, Long> {

    Iterable<Product> findAllByTitleEquals(String title);

    @Query("{\n" +
            "  \"query\": {\n" +
            "    \"match\": {\n" +
            "      \"title\": \"?0\"\n" + // Assuming 'title' is a field in your OpenSearch index
            "    }\n" +
            "  }\n" +
            "}")
    List<Product> findAllByTitleContaining(String query);
    //void deleteProductById(Long id);
}
