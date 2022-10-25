package com.sheryians.major.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sheryians.major.model.Category;
import com.sheryians.major.model.Product;

public interface CategoryRepository extends JpaRepository<Category,Integer>
{
	
	List<Category> findByDeleted(int deleted);
}
