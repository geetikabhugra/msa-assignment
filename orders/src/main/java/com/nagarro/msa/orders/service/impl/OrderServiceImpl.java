package com.nagarro.msa.orders.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nagarro.msa.orders.model.Order;
import com.nagarro.msa.orders.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Override
	public List<Order> getOrdersByUserId(Long userId) {
		List<Order> orders = getAllOrders().stream()
				.filter(o -> userId.equals(o.getUserId())).collect(Collectors.toList());
		return orders;
	}
	
	protected List<Order> getAllOrders() {
		List<Order> orders = new ArrayList<>();
		orders.add(new Order((long) 1, (long) 1, BigDecimal.valueOf((long) 250), "14-Apr-2020"));
		orders.add(new Order((long) 2, (long) 1, BigDecimal.valueOf((long) 450), "15-Apr-2020"));
		return orders;
	}

}
