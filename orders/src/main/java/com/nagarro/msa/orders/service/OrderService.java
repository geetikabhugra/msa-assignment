package com.nagarro.msa.orders.service;

import java.util.List;

import com.nagarro.msa.orders.model.Order;

public interface OrderService {
	
	List<Order> getOrdersByUserId(Long userId);

}
