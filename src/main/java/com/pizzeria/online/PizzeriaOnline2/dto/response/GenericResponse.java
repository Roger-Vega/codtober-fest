package com.pizzeria.online.PizzeriaOnline2.dto.response;

import java.io.Serializable;

public class GenericResponse implements Serializable{
	
	private boolean result;
	private String message;
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
