package com.example.productservice_proxy.config;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

    @Configuration
    @EnableElasticsearchRepositories(basePackages = "com.example.productservice_proxy.ElasticsearchRepo")
    public class elasticConfig {
        // You might add Elasticsearch-specific bean configurations here if needed
    }