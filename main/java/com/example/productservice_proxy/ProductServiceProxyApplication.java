package com.example.productservice_proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

@SpringBootApplication
public class ProductServiceProxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceProxyApplication.class, args);


    }
}
