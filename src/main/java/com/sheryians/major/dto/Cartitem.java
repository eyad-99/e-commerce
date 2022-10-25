package com.sheryians.major.dto;

import com.sheryians.major.model.Product;

public class Cartitem {
	
	
	private int count;
	
	private Product product;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
