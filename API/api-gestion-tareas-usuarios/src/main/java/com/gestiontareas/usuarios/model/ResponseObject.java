package com.gestiontareas.usuarios.model;

public class ResponseObject {
	
	private String state;
	private String message;
	private Object data;
	
	public ResponseObject() {}
	
	public ResponseObject(String state, String message, Object data) {
		this.state = state;
		this.message = message;
		this.data = data;
	}

	public ResponseObject(String state, String message) {
		this.state = state;
		this.message = message;
	}	
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

}
