package com.nagarro.msa.orders.model;

import java.math.BigDecimal;

import com.google.gson.annotations.Expose;

public class Order {
	
	@Expose
	private Long orderId;
	
	private Long userId;
	
	@Expose
	private BigDecimal orderAmount;
	
	@Expose
	private String orderDate;
	
	public Order(Long orderId, Long userId, BigDecimal orderAmount, String orderDate) {
		this.orderId = orderId;
		this.userId = userId;
		this.orderAmount = orderAmount;
		this.orderDate = orderDate;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public BigDecimal getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

}
