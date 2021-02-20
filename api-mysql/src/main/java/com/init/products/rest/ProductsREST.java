package com.init.products.rest;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.init.products.dao.ProductsDAO;
import com.init.products.entity.Product;
import com.sun.el.stream.Optional;

@RestController
@RequestMapping("products") // /products
public class ProductsREST {

	@Autowired
	private ProductsDAO productsDAO;

	@GetMapping
	public ResponseEntity<List<Product>> getProducts() {

		List<Product> products = productsDAO.findAll();
		// System.out.println(product);
		return ResponseEntity.ok(products);

	}

	@RequestMapping(value = "{productId}") //products/productId -> products/1
	public ResponseEntity<Product> getProductById(@PathVariable("productId") Long productId){
				
		java.util.Optional<Product> coptionalproduct = productsDAO.findById(productId);
		//   System.out.println(product);		
		if (coptionalproduct.isPresent()) {
			return ResponseEntity.ok(coptionalproduct.get());	
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	@PostMapping	// /product en el metodo POST
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		Product newProduct = productsDAO.save(product);
		return ResponseEntity.ok(newProduct);
		
	}	
	@DeleteMapping(value = "{productId}") // /product en el metodo DELETE
	public ResponseEntity<Void> deleteProduct(@PathVariable("productId")  long productId){
		
		 productsDAO.deleteById(productId);
		return ResponseEntity.ok(null);
		
	}	 
	@PutMapping
	public ResponseEntity<Product> updateProduct(@RequestBody Product product){
		
		java.util.Optional<Product> optionalproduct = productsDAO.findById(product.getId());
		//   System.out.println(product);		
		if (optionalproduct.isPresent()) {
			Product updateproduct = optionalproduct.get();
			updateproduct.setName(product.getName());
			productsDAO.save(updateproduct);
			
			return ResponseEntity.ok(updateproduct);	
		} else {
			return ResponseEntity.notFound().build();
		}
		
		
	}

	// @GetMapping //locahost:8082
	@RequestMapping(value = "hello", method = RequestMethod.GET)
	public String Hello() {

		return "Hello World!";
	}
}
