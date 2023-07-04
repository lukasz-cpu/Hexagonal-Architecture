package com.hexagonalexample.domain.product.adapter;

import com.hexagonalexample.domain.common.emailnotification.EmailNotificationPort;
import com.hexagonalexample.domain.product.model.Product;
import com.hexagonalexample.domain.product.port.out.ProductRepositoryPort;
import com.hexagonalexample.domain.product.service.ProductService;
import com.hexagonalexample.infrastructure.notification.inmemory.email.EmailNotoficationAdapter;
import com.hexagonalexample.infrastructure.persistence.inmemory.ProductInMemoryAdapter;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProductServiceAdapterTest {

    private final EmailNotificationPort emailNotificationPort = new EmailNotoficationAdapter();
    private final ProductRepositoryPort productRepositoryPort = new ProductInMemoryAdapter();
    private final ProductService productService = new ProductService(productRepositoryPort, emailNotificationPort);
    private final ProductServiceAdapter productServiceAdapter = new ProductServiceAdapter(productService);



    @Test
    void getProducts() {
        //given
        Product product = new Product(1L, "Test object", "Test description");
        //when
        productServiceAdapter.addProduct(product);
        //then
        List<Product> all = productRepositoryPort.findAll();
        assertThat(all).size().isEqualTo(1);
    }

    @Test
    void addProduct() {
        //given
        productRepositoryPort.save(new Product(1L, "Test object", "Test description"));
        //when
        List<Product> products = productServiceAdapter.getProducts();
        //then
        assertThat(products).size().isEqualTo(1);
    }
}