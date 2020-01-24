package com.c2c.c2c_api.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.c2c.c2c_api.model.Product;
import com.c2c.c2c_api.model.service.ProductService;
import com.c2c.c2c_api.model.sevice.impl.ProductServiceImpl;



@CrossOrigin("*")
@RestController
public class ProductController {
	
	ProductService productService = new ProductServiceImpl();
	
	@GetMapping("/produto")
	public List<Product> getAll() {
		return productService.getAll();
	}

	@GetMapping("/produto/{id}")
	public ResponseEntity<Product> getById(@PathVariable int id) {

		Product product = productService.getById(id);
		
		if (product == null)
			ResponseEntity.notFound();

		return ResponseEntity.ok(product);
	}

	@PostMapping("/produto")
	public ResponseEntity<Product> insert(@RequestBody Product product) {
		if (product.getId() != 0)
			return ResponseEntity.badRequest().body(product);

		productService.insert(product);
		return ResponseEntity.ok(product);
	}

	@PutMapping("/produto")
	public Product alterar(@RequestBody Product product) {
		productService.update(product);
		return product;
	}
	
	@DeleteMapping("/produto/{id}")
	public void delete(@PathVariable int id) {
		productService.delete(id);
	}
	
	
	

}
