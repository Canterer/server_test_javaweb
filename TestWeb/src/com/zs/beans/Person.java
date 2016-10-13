package com.zs.beans;

public class Person {
	private int id;
	private String username;
	private String password;
	
	public Person(int id, String user_name, String password){
		this.setId(id);
		this.setUsername(username);
		this.setPassword(password);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}

