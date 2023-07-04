package com.hexagonalexample.infrastructure.persistence.database.product.repository;

import com.hexagonalexample.infrastructure.persistence.database.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
