package com.sheryians.major.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.sheryians.major.dto.Cartitem;
import com.sheryians.major.global.GlobalData;
import com.sheryians.major.model.Category;
import com.sheryians.major.model.Order;
import com.sheryians.major.model.Orderproduct;
import com.sheryians.major.model.Product;
import com.sheryians.major.model.User;
import com.sheryians.major.repository.CategoryRepository;
import com.sheryians.major.repository.OrderRepository;
import com.sheryians.major.repository.Orderproduct_Repository;
import com.sheryians.major.repository.UserRepository;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository  orderRepository;
	
	@Autowired
	UserRepository  userRepository;
	
	@Autowired
	Orderproduct_Repository  orderProductRepository;
	
	
	public User getCurrentUser()
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		Optional<User> user=userRepository.findUserByEmail(userDetails.getUsername());
		System.out.println(user.get().getEmail());
		return user.get();

	}
	
	public void addOrder(Order order)
	{
		order.setUser(getCurrentUser());
		orderRepository.save(order);
		for(Cartitem item:GlobalData.cart)
		{
			Orderproduct od=new Orderproduct();
			od.setCount(item.getCount());
			od.setProduct(item.getProduct());
			od.setOrder(order);
			orderProductRepository.save(od);
		}
		
	}
	
	
	public static double computePrice()
	{
		double price=0;
		for(Cartitem item:GlobalData.cart)
		{
			price+= item.getCount()*item.getProduct().getPrice();
		}
		return price;
		
	}
	
	public List<Order> getUserOrder()
	{
		return orderRepository.findByUser(getCurrentUser());
	}
	
	
	public Order findOrder(int id)
	{
		return orderRepository.getOne(id);
	}
	
	
	public List<Orderproduct> getProducts(int id)
	{
		return orderProductRepository.findByOrder(findOrder(id));
	}

}
