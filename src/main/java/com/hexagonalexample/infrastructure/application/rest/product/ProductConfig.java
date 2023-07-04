package com.hexagonalexample.infrastructure.application.rest.product;

import com.hexagonalexample.domain.common.emailnotification.EmailNotificationPort;
import com.hexagonalexample.domain.product.adapter.ProductServiceAdapter;
import com.hexagonalexample.domain.product.port.in.ProductServicePort;
import com.hexagonalexample.domain.product.port.out.ProductRepositoryPort;
import com.hexagonalexample.domain.product.service.ProductService;
import com.hexagonalexample.infrastructure.notification.inmemory.email.EmailNotoficationAdapter;
import com.hexagonalexample.infrastructure.persistence.inmemory.ProductInMemoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class ProductConfig {

    @Bean
    public ProductRepositoryPort productRepositoryPort() {
        return new ProductInMemoryAdapter();
    }

    @Bean
    public ProductService productService(ProductRepositoryPort productRepositoryPort, EmailNotificationPort emailNotificationPort) {
        return new ProductService(productRepositoryPort, emailNotificationPort);
    }


    @Bean
    public ProductServicePort productServicePort(ProductService productService) {
        return new ProductServiceAdapter(productService);
    }

    @Bean
    public EmailNotificationPort emailNotificationPort(){
        return new EmailNotoficationAdapter();
    }


}
