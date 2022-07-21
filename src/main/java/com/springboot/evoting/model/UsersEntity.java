package com.springboot.evoting.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity

@Table(name = "user")
public class UsersEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="user_id")

	private int userId;
	
	@Column(name ="user_name")
	private String userName;
	
	@Column(name ="user_email")
	private String userEmail;
	
	@Column(name ="user_password")
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "user_roles",
	
			joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "user_id"),
			
			inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id")
	
	
			)
	private Set<RolesEntity> roles;
	
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy ="user",fetch = FetchType.LAZY)
	private VoterEntity voter;

	public UsersEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsersEntity(int userId, String userName, String userEmail, String password, Set<RolesEntity> roles,
			VoterEntity voter) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.password = password;
		this.roles = roles;
		this.voter = voter;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public Set<RolesEntity> getRoles() {
		return roles;
	}

	public void setRoles(Set<RolesEntity> roles) {
		this.roles = roles;
	}

	public VoterEntity getVoter() {
		return voter;
	}

	public void setVoter(VoterEntity voter) {
		this.voter = voter;
	}

	
	
	
	

}
