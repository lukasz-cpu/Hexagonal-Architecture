package com.hexagonalexample.infrastructure.application.rest.product;

import com.hexagonalexample.domain.product.model.Product;
import com.hexagonalexample.domain.product.port.in.ProductServicePort;
import com.hexagonalexample.infrastructure.application.rest.product.dto.ProductDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/products")
    public Product addProduct(@RequestBody ProductDTO product){
        return productServicePort.addProduct(new Product(product.name(), product.description()));
    }
}
