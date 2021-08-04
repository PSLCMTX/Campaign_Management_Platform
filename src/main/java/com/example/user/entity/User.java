package com.example.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "user" )
@Entity
public class User {
	
	@Transient
	public static final String SEQUENCE_NAME ="user_sequence";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@NotNull(message = "Name can not be null")
	private String name;
	@Size(min = 10,max=10,message = "Invalid phone number")
	@NotNull(message = "Phone number can not be empty")
	private String phone;
	@Email(message = "Email is not valid")
	@NotNull(message = "Email can not be empty")
	private String email;
	@NotNull(message = "Age can not be empty")
	private int age;
	@Column(nullable = true)
	private String address;
	@Enumerated(EnumType.STRING)
	private State state;
	
	public User(int id, String name, String phone, String email, int age, String address, State state) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.age = age;
		this.address = address;
		this.state = state;
	}

	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", age=" + age
				+ ", address=" + address + ", state=" + state + "]";
	}
	
	
	
	
	
	

}
