package com.sheryians.major.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheryians.major.model.Category;
import com.sheryians.major.model.Product;
import com.sheryians.major.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository  categoryRepository;
	
	public List<Category> getAllCategory()
	{
		return categoryRepository.findByDeleted(0);
		
	}
	
	public void addCategory(Category category)
	{
		categoryRepository.save(category);
	}
	
	
	public void removeCategoryById(int id)
	{
		Category category=categoryRepository.getOne(id);
		category.setDeleted(1);
		List<Product> products=category.getProducts();
		for(Product p : products)
			p.setDeleted(1);
		categoryRepository.save(category);
	}
	
	
	public Optional<Category> getCategoryById(int id)
	{
		return categoryRepository.findById(id);
	}

}
