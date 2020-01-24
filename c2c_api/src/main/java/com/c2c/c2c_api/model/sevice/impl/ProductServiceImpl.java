package com.c2c.c2c_api.model.sevice.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.c2c.c2c_api.model.Product;
import com.c2c.c2c_api.model.service.ProductService;


public class ProductServiceImpl implements ProductService {

	static List<Product> produtos = new ArrayList<Product>();
	private static int inc = 0;

	@Override
	public Product insert(Product product) {

		inc++;
		product.setId(inc);

		this.produtos.add(product);

		return product;
	}

	@Override
	public Product update(Product product) {
		
		
		Product aux = getById(product.getId());
		
		if(aux != null) {
			
			aux.setPrice(product.getPrice());
			aux.setName(product.getName());
			aux.setDescription(product.getDescription());
			aux.setImgUrl(product.getImgUrl());
			
		}
		return null;
	}

	@Override
	public void delete(Product product) {
		delete(product.getId());
	}

	@Override
	public void delete(int id) {
		

		for (Iterator<Product> i = produtos.iterator(); i.hasNext();) {
			Product productDelete = i.next();

			if (productDelete.getId() == id) {
				i.remove();

			}

		}

	}

	@Override
	public Product getById(int id) {
		for (Product product : produtos) {
			if(product.getId() == id) {
				return product;
			}
		}
		return null;
	}

	@Override
	public List<Product> getAll() {

		return produtos;
	}

}
