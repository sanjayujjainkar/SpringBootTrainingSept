package com.example.service;

import java.util.List;

import com.example.entiry.Product;

public interface ProductService {
	
	
	List<Product> getAllProducts();
	
	Product saveProduct(Product product);
	
	Product updateProduct(Integer pid, Product product);
	
	Product deleteProduct(Integer pid);
	
	
}