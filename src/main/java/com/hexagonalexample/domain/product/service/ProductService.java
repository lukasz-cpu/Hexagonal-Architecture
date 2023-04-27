package com.hexagonalexample.domain.product.service;

import com.hexagonalexample.domain.product.model.Product;
import com.hexagonalexample.domain.product.port.out.ProductRepositoryPort;

import java.util.List;

public class ProductService {

    private final ProductRepositoryPort productRepositoryPort;

    public ProductService(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    public List<Product> getProducts() {
        return productRepositoryPort.findAll();
    }

    public Product addProduct(Product product) {
        return productRepositoryPort.save(product);
    }
}