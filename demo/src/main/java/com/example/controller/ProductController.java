package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.ProductService;
import com.example.entiry.Product;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public List<Product> getProducts() {
		return productService.getAllProducts();
	}
	
	@PostMapping("/product")
	public Product saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	@PostMapping("/product/{id}")
	public Product updateProduct(@PathVariable Integer pid, @RequestBody Product product) {
		return productService.updateProduct(pid, product);
	}
	
	

}
