package com.example.extendeddemo.adminandenduser.service;

import com.example.extendeddemo.admin.model.Orders;
import com.example.extendeddemo.admin.model.Users;

public interface IOrderService {
	public Boolean placeOrder(Users users, Orders order);

}

