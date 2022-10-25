package com.sheryians.major.global;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sheryians.major.dto.Cartitem;
import com.sheryians.major.model.Product;

public class GlobalData {
	public static List<Cartitem> cart;
	
	static
	{
		cart=new ArrayList<Cartitem>();
	}

}
