package com.hcl.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.model.Product;
import com.hcl.service.ProductServices;


@RestController
public class ProductController 
{

	@Autowired
	private ProductServices service;
	
	@GetMapping("/getproductlist")
	public List<Product> feachProductList()
	{
		List<Product> products=new ArrayList<Product>();
		
		products=service.feachProductList();
		return products;

	}

	@GetMapping("/getproduct/{id}")
	public Product feachProductById(@PathVariable int id)
	{
		return service.feachProductById(id).get();
	}


	@PostMapping("/addproduct")
	public Product addProductList(@RequestBody Product Product)
	{
		
		return service.addProductToDB(Product);

	}

	@DeleteMapping("/deleteProduct")
	public String deleteProduct(@PathVariable int id)
	{
		
		return service.deleteProductById(id);

	}

}
