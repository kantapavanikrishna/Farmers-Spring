package com.example.Farmers.Entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "farmers")
public class Farmers implements Serializable{

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
	private int id;
	
	private String username;
	
	private String phone;

	private String address;
	
	private String email;
	
	private String product;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String pwd;
	public Farmers(int id, String username, String phone, String address, String email, String product, String pwd) {
		super();
		this.id = id;
		this.username = username;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.product = product;
		
		this.pwd = pwd;
	}
	public Farmers() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Farmers [id=" + id + ", username=" + username + ", phone=" + phone + ", address=" + address + ", email="
				+ email + ", product=" + product + ", pwd=" + pwd + "]";
	}
	

	
}
