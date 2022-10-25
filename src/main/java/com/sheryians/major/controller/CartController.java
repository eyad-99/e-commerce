package com.sheryians.major.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sheryians.major.dto.Cartitem;
import com.sheryians.major.global.GlobalData;
import com.sheryians.major.model.Order;
import com.sheryians.major.model.Product;
import com.sheryians.major.repository.OrderRepository;
import com.sheryians.major.service.OrderService;
import com.sheryians.major.service.ProductService;

@Controller
public class CartController
{
	@Autowired
	ProductService  productService;
	
	
	@Autowired
	OrderService orderservice;
	
	
	@GetMapping("/addToCart/{id}")
	public String addToCart(@PathVariable int id,@RequestParam("count") int count)
	{
		System.out.println("the countttttttttttttt");
		System.out.println(count);
		Cartitem item= new Cartitem(); 
		item.setProduct(productService.getProductById(id).get());
		item.setCount(count);
		GlobalData.cart.add(item);
		return "redirect:/shop";
	}
	
	

	@GetMapping("/cart")
	public String cartGet(Model model)
	{
		model.addAttribute("cartCount",GlobalData.cart.size());
		model.addAttribute("total",OrderService.computePrice());

		model.addAttribute("cart",GlobalData.cart);
		//System.out.println("verify it matches");
		//System.out.println(list);
		//System.out.println(count);
		return "cart";
	}
	
	
	@GetMapping("/cart/removeItem/{index}")
	public String cartItemRemove( @PathVariable int index)
	{
		GlobalData.cart.remove(index);
		return "redirect:/cart";
	}
	
	
	@GetMapping("/checkout")
	public String checkout( Model model)
	{
		model.addAttribute("total",OrderService.computePrice());		
		model.addAttribute("order",new Order());
		return "checkout";
	}
	
	

	@PostMapping("checkout/submit")
	public String submit( @ModelAttribute("order") Order order,Model model)
	{
		model.addAttribute("total",OrderService.computePrice());		
		orderservice.addOrder(order);
		GlobalData.cart.clear();
		return "redirect:/cart";	
		}
	
	
	
	@GetMapping("/orders/details")
	public String submit(@RequestParam("id") int id,Model model)
	{
		model.addAttribute("products",orderservice.getProducts(id));		
	
		return "orderdetails";	
		}
	
	

}

	
	


