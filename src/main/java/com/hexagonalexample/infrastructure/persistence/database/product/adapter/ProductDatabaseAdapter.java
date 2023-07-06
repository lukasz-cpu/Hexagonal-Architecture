package com.hexagonalexample.infrastructure.persistence.database.product.adapter;

import com.hexagonalexample.domain.product.model.Product;
import com.hexagonalexample.domain.product.port.out.ProductRepositoryPort;
import com.hexagonalexample.infrastructure.persistence.database.product.entity.ProductEntity;
import com.hexagonalexample.infrastructure.persistence.database.product.repository.ProductRepository;

import java.util.List;

public class ProductDatabaseAdapter implements ProductRepositoryPort {

    private final ProductRepository productRepository;

    public ProductDatabaseAdapter(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll()
                .stream()
                .map(productEntity -> new Product(productEntity.getId(), productEntity.getName(), productEntity.getDescription()))
                .toList();
    }

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = new ProductEntity(product.getName(), product.getDescription());
        ProductEntity savedProduct = productRepository.save(productEntity);
        return new Product(savedProduct.getId(), savedProduct.getName(), savedProduct.getDescription());
    }
}
