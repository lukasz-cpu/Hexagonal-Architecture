package com.hexagonalexample.domain.product.service;

import com.hexagonalexample.domain.common.emailnotification.EmailNotificationPort;
import com.hexagonalexample.domain.product.model.Product;
import com.hexagonalexample.domain.product.port.out.ProductRepositoryPort;

import java.util.List;

public class ProductService {

    private final ProductRepositoryPort productRepositoryPort;
    private final EmailNotificationPort emailNotificationPort;

    public ProductService(ProductRepositoryPort productRepositoryPort, EmailNotificationPort emailNotificationPort) {
        this.productRepositoryPort = productRepositoryPort;
        this.emailNotificationPort = emailNotificationPort;
    }

    public List<Product> getProducts() {
        return productRepositoryPort.findAll();
    }

    public Product addProduct(Product product) {
        Product addedProduct = productRepositoryPort.save(product);
        emailNotificationPort.send(List.of("admin@admin.pl"), "Product o id: " + addedProduct.id() +" zostal dodany");
        return addedProduct;
    }
}