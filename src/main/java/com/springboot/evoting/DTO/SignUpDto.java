package com.springboot.evoting.DTO;

public class SignUpDto {
	private String userName;
	private String userEmail;
	private String password;
	public SignUpDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SignUpDto(String userName, String userEmail, String password) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
