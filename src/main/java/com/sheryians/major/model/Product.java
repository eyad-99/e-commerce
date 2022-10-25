package com.sheryians.major.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="category_id",referencedColumnName="category_id")
	private Category category;
	
	
   private int deleted=0;
	
	
	public int getDeleted() {
		return deleted;
	}



	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	@OneToMany(mappedBy="product",cascade = CascadeType.ALL)
	List<Orderproduct> orderproduct;
	
	public List<Orderproduct> getOrderproduct() {
		return orderproduct;
	}
	public void setOrderproduct(List<Orderproduct> orderproduct) {
		this.orderproduct = orderproduct;
	}
	public void setId(Long id) {
		this.id = id;
	}
	private double price;
	
	private double weight;
	private String description;
	private String imageName;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	
	

}
