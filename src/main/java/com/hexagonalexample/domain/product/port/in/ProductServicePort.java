package com.hexagonalexample.domain.product.port.in;

import com.hexagonalexample.domain.product.model.Product;

import java.util.List;

public interface ProductServicePort {

    List<Product> getProducts();

}