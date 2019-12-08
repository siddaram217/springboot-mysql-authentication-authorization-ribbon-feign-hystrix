package com.candidate.model;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	public User() {
	}
	public User(User user) {
		this.email=user.email;
		this.firstName=user.firstName;
		this.isActive=user.isActive;
		this.lastName=user.lastName;
		this.password=user.password;
		this.roles=user.roles;
		this.userId=user.userId;
		this.username=user.username;
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "user_name", nullable = false, length = 10, unique = true)
	private String username;

	@Column(name = "password", nullable = false, length = 15)
	private String password;

	@Column(name = "first_name", length = 15, nullable = false)
	private String firstName;

	@Column(name = "last_name", length = 15)
	private String lastName;

	@Column(name = "email", length = 25)
	private String email;

	@Column(name = "is_active", length = 1)
	private int isActive;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
	private Set<Role> roles;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", isActive=" + isActive + ", roles="
				+ roles + "]";
	}

}
