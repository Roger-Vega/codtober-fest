package com.pizzeria.online.PizzeriaOnline2.dto.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.pizzeria.online.PizzeriaOnline2.models.Ingredient;
import com.pizzeria.online.PizzeriaOnline2.models.Size;

public class PizzaOrderResponse implements Serializable{
	private Integer id;
	private String name;
	private String address;
	private String phone;
	private Size size;
	private List<Ingredient> ingredients;
	private BigDecimal total;
	
	
	
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
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
}
