package com.springboot.evoting.DTO;

public class LogInDto {
	
	private String userEmail;
	
	private String password;

	public LogInDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LogInDto(String userEmail, String password) {
		super();
		this.userEmail = userEmail;
		this.password = password;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	

}
