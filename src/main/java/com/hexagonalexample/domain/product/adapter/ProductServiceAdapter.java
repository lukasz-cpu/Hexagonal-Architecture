package com.hexagonalexample.domain.product.adapter;

import com.hexagonalexample.domain.product.model.Product;
import com.hexagonalexample.domain.product.port.in.ProductServicePort;
import com.hexagonalexample.domain.product.service.ProductService;

import java.util.List;

public class ProductServiceAdapter implements ProductServicePort {

    private final ProductService productService;

    public ProductServiceAdapter(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @Override
    public Product addProduct(Product product) {
        return productService.addProduct(product);
    }
}
