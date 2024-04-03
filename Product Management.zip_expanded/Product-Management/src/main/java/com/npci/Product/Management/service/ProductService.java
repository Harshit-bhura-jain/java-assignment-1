package com.npci.Product.Management.service;

import java.util.List;
import java.util.Map;

import com.npci.Product.Management.beans.Product;

public interface ProductService {

	public Product addProduct(Product product);
	
	public List<Product> getProducts();
	
	public Map<String,Object> generateBills();
	
	
}
