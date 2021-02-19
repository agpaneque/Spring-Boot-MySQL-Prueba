package com.init.products.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.init.products.entity.Product;

@RestController
@RequestMapping("products")
public class ProductsREST {
	
	@GetMapping
	public ResponseEntity<Product> getProduct(){
		Product product = new Product();
		product.setId(1L);
		product.setName("Producto 33");
		
		return ResponseEntity.ok(product);
	//	return null;
	}
	/*
	 * //@GetMapping //locahost:8080/
	 * 
	 * @RequestMapping(value = "hello",method = RequestMethod.GET) public String
	 * hello() {
	 * 
	 * return "Hello World!!"; }
	 */
}
