package com.hexagonalexample.infrastructure.persistence.inmemory;

import com.hexagonalexample.domain.product.model.Product;
import com.hexagonalexample.domain.product.port.out.ProductRepositoryPort;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ProductInMemoryAdapter implements ProductRepositoryPort {

    private final Map<Long, Product> store = new ConcurrentHashMap<>();

    @Override
    public List<Product> findAll() {
        return List.of(
                new Product(1L, "Product One", "Description One"),
                new Product(1L, "Product One", "Description One")
        );

    }

    @Override
    public Product save(Product product) {
        store.put(product.id(), product);
        return product;
    }
}
