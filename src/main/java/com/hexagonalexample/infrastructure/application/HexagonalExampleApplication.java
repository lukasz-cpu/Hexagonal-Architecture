package com.hexagonalexample.infrastructure.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.hexagonalexample.infrastructure.persistence.database"})
@EntityScan(basePackages = {"com.hexagonalexample.infrastructure.persistence.database"})
public class HexagonalExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(HexagonalExampleApplication.class, args);
	}

}
