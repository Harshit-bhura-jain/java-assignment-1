package com.npci.Product.Management.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npci.Product.Management.beans.Product;
import com.npci.Product.Management.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    
	private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
	
	
	@PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product addedProduct = productService.addProduct(product);
        return new ResponseEntity<>(addedProduct, HttpStatus.CREATED);
    }
	
	@GetMapping("/generateBills")
    public ResponseEntity<Map<String, Object>> generateBills() {
        Map<String, Object> bills = productService.generateBills();
        return new ResponseEntity<>(bills, HttpStatus.OK);
    }
	
	@GetMapping("/allproduct")
	 public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
	
}
