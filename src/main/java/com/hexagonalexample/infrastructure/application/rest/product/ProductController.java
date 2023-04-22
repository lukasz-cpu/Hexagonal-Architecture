package com.hexagonalexample.infrastructure.application.rest.product;

import com.hexagonalexample.domain.product.model.Product;
import com.hexagonalexample.domain.product.port.in.ProductServicePort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {


    private final ProductServicePort productServicePort;

    public ProductController(ProductServicePort productServicePort) {
        this.productServicePort = productServicePort;
    }

    @GetMapping("/products")
    public List<Product> getProduct() {
        return productServicePort.getProducts();
    }
}
