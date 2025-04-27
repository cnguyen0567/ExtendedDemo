package com.example.extendeddemo.adminandenduser.dao;

import com.example.extendeddemo.admin.model.Orders;
import com.example.extendeddemo.admin.model.Users;
//examples of how to finish the demo
public interface IOrderDAO {
	public Boolean placeOrder(Users users, Orders order);
	
	public Orders getOrderDetails(int orderId);
}

