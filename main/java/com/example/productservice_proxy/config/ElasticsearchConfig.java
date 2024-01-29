package com.example.productservice_proxy.config;

import com.example.productservice_proxy.Repositories.ProductSearchRepo;
import org.opensearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
//import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.repository.config.EnableReactiveElasticsearchRepositories;
import org.springframework.data.elasticsearch.repository.config.EnableReactiveElasticsearchRepositories;

//
//@Configuration
//@EnableElasticsearchRepositories(basePackages = "com.example.productservice_proxy.Repositories")
//public class ElasticsearchConfig {
//
//}
//
