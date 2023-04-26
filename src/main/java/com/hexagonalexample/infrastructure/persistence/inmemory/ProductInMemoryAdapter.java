package com.hexagonalexample.infrastructure.persistence.inmemory;

import com.hexagonalexample.domain.product.model.Product;
import com.hexagonalexample.domain.product.port.out.ProductRepositoryPort;

import java.util.List;

public class ProductInMemoryAdapter implements ProductRepositoryPort {
    @Override
    public List<Product> findAll() {
        return null;
    }
}
