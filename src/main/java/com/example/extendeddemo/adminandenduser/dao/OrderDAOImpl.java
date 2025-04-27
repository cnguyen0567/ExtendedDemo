package com.example.extendeddemo.adminandenduser.dao;

import java.util.HashMap;
import java.util.Map;

import com.example.extendeddemo.admin.model.Orders;
import com.example.extendeddemo.admin.model.Users;
//examples of how to finish the demo
public class OrderDAOImpl implements IOrderDAO {
	//Fields:
	private Map<Integer, Users> userEntry;
	private Map<Integer, Orders> orderEntry;
	
	/* Constructor */
	public OrderDAOImpl() {
		userEntry = new HashMap<>();
		orderEntry = new HashMap<>();
		// TODO Auto-generated constructor stub
	}

	/* Method */
	@Override
	public Boolean placeOrder(Users users, Orders order) {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public Orders getOrderDetails(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

}
