package com.pizzeria.online.PizzeriaOnline2.request;

import java.io.Serializable;

public class ViewOrderRequest implements Serializable{
	
	private Integer orderId;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "ViewOrderRequest [orderId=" + orderId + "]";
	}
	
	

}
