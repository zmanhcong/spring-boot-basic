package edu.poly.hello.service;

import java.util.List;

import edu.poly.hello.model.Product;

public interface ProductService {

	Product findByid(int productId);

	void update(Product product);

	List<Product> findAll();

	void remove(int productId);

	void add(Product product);

}
