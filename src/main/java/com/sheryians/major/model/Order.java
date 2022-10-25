package com.sheryians.major.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sheryians.major.global.GlobalData;
import com.sheryians.major.service.OrderService;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
public class Order 
{
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@OneToMany(mappedBy="order",cascade = CascadeType.ALL)
	List<Orderproduct> orderproduct;
	
	
	private String firstName="eyad";
	
	private String lastName="tamer";
	
	public List<Orderproduct> getOrderproduct() {
		return orderproduct;
	}

	public void setOrderproduct(List<Orderproduct> orderproduct) {
		this.orderproduct = orderproduct;
	}



	private String email="eyad@gmail.com";

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddrress1() {
		return addrress1;
	}

	public void setAddrress1(String addrress1) {
		this.addrress1 = addrress1;
	}

	public String getAddrress2() {
		return addrress2;
	}

	public void setAddrress2(String addrress2) {
		this.addrress2 = addrress2;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}



	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public Date getDate() {
		return date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@ManyToOne()
	@JoinColumn(name="user_id")
	User user;
	

	
	private String addrress1;
	
	private String addrress2;

	private String phone;
	
	private String town;
	
	
	private String postCode;
	
	private Date date=new Date(System.currentTimeMillis());
	
	//private double price=  new ArrayList<Product>(GlobalData.cart.values()).stream().mapToDouble(Product::getPrice).sum();

	private double price =OrderService.computePrice();
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}







	

}
