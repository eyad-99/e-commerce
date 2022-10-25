package com.sheryians.major.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sheryians.major.model.Order;
import com.sheryians.major.model.Orderproduct;

public interface Orderproduct_Repository   extends JpaRepository<Orderproduct,	Integer> {
	
	public List<Orderproduct> findByOrder(Order order);

}
