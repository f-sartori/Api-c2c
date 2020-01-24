package com.c2c.c2c_api.model.service;

import java.util.List;

import com.c2c.c2c_api.model.Product;


public interface ProductService {
	
	Product insert(Product product);
	
	Product update(Product product);
	
	void delete(Product product);
	
	void delete(int id);
	
	Product getById(int id);
	
	List<Product> getAll();
	

}
