package com.hexagonalexample.domain.product.adapter;

import com.hexagonalexample.domain.common.emailnotification.EmailNotificationPort;
import com.hexagonalexample.domain.product.model.Product;
import com.hexagonalexample.domain.product.port.out.ProductRepositoryPort;
import com.hexagonalexample.domain.product.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceAdapterMockTest {

    private final EmailNotificationPort emailNotificationPort = mock(EmailNotificationPort.class);
    private final ProductRepositoryPort productRepositoryPort = mock(ProductRepositoryPort.class);
    private final ProductService productService = new ProductService(productRepositoryPort, emailNotificationPort);
    private final ProductServiceAdapter productServiceAdapter = new ProductServiceAdapter(productService);



    @Test
    void getProducts() {
        //given
        Product product = new Product(1L, "Test object", "Test description");
        when(productRepositoryPort.save(any())).then(invocation -> product);
        //when
        Product result = productServiceAdapter.addProduct(product);
        //then
        assertThat(result).isNotNull();

    }

    @Test
    void addProduct() {
        //given
        Product product = new Product(1L, "Test object", "Test description");
        when(productRepositoryPort.save(any())).then(invocation -> product);
        //when
        Product resultProduct = productServiceAdapter.addProduct(product);
        //then
        assertThat(resultProduct).isNotNull();
        assertThat(resultProduct.id()).isEqualTo(1L);

    }
}

