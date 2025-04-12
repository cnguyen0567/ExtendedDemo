package com.example.extendeddemo.adminandenduser.service;

import com.example.extendeddemo.admin.model.Orders;
import com.example.extendeddemo.admin.model.Users;
import com.example.extendeddemo.adminandenduser.dao.IOrderDAO;
import com.example.extendeddemo.adminandenduser.dao.OrderDAOImpl;

public class OrderServiceImpl implements IOrderService { 
	/* Fields */
	private IOrderDAO dao; //an object field of the DAO interface
	
	public OrderServiceImpl() {
		dao = new OrderDAOImpl(); //instantize the dao object
	}

	@Override
	public Boolean placeOrder(Users users, Orders order) {
		// TODO Auto-generated method stub
		Boolean true_false = dao.placeOrder(users, order);  //call a method in the dao class
		return true_false;
	}
}
