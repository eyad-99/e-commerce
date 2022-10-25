package com.sheryians.major.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sheryians.major.model.Order;
import com.sheryians.major.model.Product;
import com.sheryians.major.model.User;

public interface OrderRepository   extends JpaRepository<Order,	Integer>{
	
	List<Order> findByUser(User user);

}
