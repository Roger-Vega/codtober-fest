package com.pizzeria.online.PizzeriaOnline2.dto.response;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrdersResponse implements Serializable{
	
	private Integer id;
	private String name;
	private String address;
	private BigDecimal total;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
