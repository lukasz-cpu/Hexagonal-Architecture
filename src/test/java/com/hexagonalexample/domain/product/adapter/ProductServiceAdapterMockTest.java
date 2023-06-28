package com.hexagonalexample.domain.product.adapter;

import com.hexagonalexample.domain.product.model.Product;
import com.hexagonalexample.domain.product.port.out.ProductRepositoryPort;
import com.hexagonalexample.domain.product.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceAdapterMockTest {

    private final ProductRepositoryPort productRepositoryPort = mock(ProductRepositoryPort.class);
    private final ProductService productService = new ProductService(productRepositoryPort);
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
        when(productRepositoryPort.findAll()).then(invocation -> List.of(product));
        //when
        List<Product> products = productServiceAdapter.getProducts();
        //then
        assertThat(products).size().isEqualTo(1);

    }
}

