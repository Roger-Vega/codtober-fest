package com.pizzeria.online.PizzeriaOnline2.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class OrderRequest implements Serializable{
	
	private Integer id;
	private String name;
	private String address;
	private String phone;
	private Integer size;
	private List<Integer> ingredients;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}

	public List<Integer> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<Integer> ingredients) {
		this.ingredients = ingredients;
	}	
	
	

}
