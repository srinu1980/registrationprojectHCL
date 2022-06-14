package com.hcl.service;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.hcl.model.Product;

import com.hcl.repository.ProductRepository;

@Service
public class ProductServices 
{

	@Autowired
	 ProductRepository repo;
	
	public List<Product> feachProductList()
	{
		return repo.findAll();
	}
	
	public Optional <Product> feachProductById(int id)
	{
		return repo.findById(id);
	}
	
	public String deleteProductById(int id)
	{
		String result;
		try
		{
		 repo.deleteById(id);
		 result="Product deleted Successfully";
		}
		catch(Exception e)
		{
		result="Product with id not deleted ";	
		}
		return result;
	}
	
	public Product addProductToDB(Product product)
	{
		return repo.save(product);
	}
	
}
