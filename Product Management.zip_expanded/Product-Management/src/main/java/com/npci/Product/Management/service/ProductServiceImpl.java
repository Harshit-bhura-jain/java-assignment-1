package com.npci.Product.Management.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.npci.Product.Management.beans.Product;

@Service
public class ProductServiceImpl implements ProductService{
	
private List<Product> products;
	
	

	public ProductServiceImpl() {
		products = new ArrayList<>();
        products.add(new Product(1, "Product A", 10.0,1));
        products.add(new Product(2, "Product B", 20.0,1));
	}

	@Override
	public Product addProduct(Product product) {
		 products.add(product);
		 return product;
	}

	@Override
	public List<Product> getProducts() {
		return products;
	}

	@Override
	public Map<String, Object> generateBills() {
		Map<String, Object> bills = new HashMap<>();
        double totalAmount = 0.0;

        for (Product product : products) {
            double totalPrice = product.getPrice() * product.getQuantity();
            totalAmount += totalPrice;
        }

        double cgst = (totalAmount * 0.09);
        double sgst = (totalAmount * 0.09);
        double grandTotal = totalAmount + cgst + sgst;

        bills.put("TotalAmount", totalAmount);
        bills.put("CGST", cgst);
        bills.put("SGST", sgst);
        bills.put("GrandTotal", grandTotal);

        return bills;
	}

}
