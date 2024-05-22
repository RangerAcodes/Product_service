package com.example.productservice_proxy;

import com.example.productservice_proxy.config.elasticConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//this is a main class, this is where we add the eureka server discovery clients and other packages.

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.productservice_proxy.Repositories")
@Import(elasticConfig.class)
public class ProductServiceProxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceProxyApplication.class, args);

    }
}
