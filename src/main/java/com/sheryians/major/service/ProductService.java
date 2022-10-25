package com.sheryians.major.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheryians.major.model.Category;
import com.sheryians.major.model.Product;
import com.sheryians.major.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository Productrepository;
	
	public List<Product> getAllProduct()
	{
		return Productrepository.findByDeleted(0);
		
	}
	
	public void addProduct(Product product)
	{
		Productrepository.save(product);
		
	}
	
	
	public void removeProductById(long id)
	{
		Product product=Productrepository.getOne(id);
		product.setDeleted(1);
		Productrepository.save(product);
		
	}
	
	public Optional<Product> getProductById(long id)
	{
		return Productrepository.findById(id);
		
	}
	
	
	public List<Product> getALLProductByCategoryId(int id)
	{
		return Productrepository.findAllByCategory_IdAndDeleted(id,0);
		
	}
}
