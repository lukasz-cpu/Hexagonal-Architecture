package com.hexagonalexample.infrastructure.application.rest.product.dto;

import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public record ProductDTO(@NotEmpty Long id, @Length(min = 1)String name, @Length(min = 3) String description) {
}
