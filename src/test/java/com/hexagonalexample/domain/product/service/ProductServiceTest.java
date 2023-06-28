package com.hexagonalexample.domain.product.service;

import com.hexagonalexample.domain.product.model.Product;
import com.hexagonalexample.domain.product.port.out.ProductRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepositoryPort productRepositoryPort;

    @InjectMocks
    private ProductService productService;

    @Test
    void getProducts() {
        //given
        given(productRepositoryPort.findAll()).willReturn(List.of(new Product(1L, "Test object", "Test description")));
        //when
        List<Product> products = productService.getProducts();
        //then
        assertThat(products).size().isEqualTo(1);

    }

    @Test
    void addProduct() {
        //given
        Product product = new Product(1, "Test product", "Test description");
        //when
        productService.addProduct(product);
        //then
        verify(productRepositoryPort, times(1)).save(any());
    }
}