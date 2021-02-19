package com.init.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.init.products.entity.Product;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ProductApi21Application {
	
		

	public static void main(String[] args) {
		SpringApplication.run(ProductApi21Application.class, args);
	}

}
