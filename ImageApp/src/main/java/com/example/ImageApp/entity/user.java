//package com.example.ImageApp.entity;
//
//import jakarta.annotation.Generated;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//
//@Entity
//public class user {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private int id;
//	private String name;
//	private String password;
//	private String roles;
//	public user() {
//	super();
//	}
//	public user(int id, String name, String password,String roles) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.password = password;
//		this.roles = roles;
//	}
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getRoles() {
//		return roles;
//	}
//
//	public void setRoles(String roles) {
//		this.roles = roles;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	@Override
//	public String toString() {
//		return "user{" +
//				"id=" + id +
//				", name='" + name + '\'' +
//				", password='" + password + '\'' +
//				", roles='" + roles + '\'' +
//				'}';
//	}
//}
