package com.hexagonalexample.domain.product.port.out;

import com.hexagonalexample.domain.product.model.Product;

import java.util.List;

public interface ProductRepositoryPort {
    List<Product> findAll();
}
