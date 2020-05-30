package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Trainer {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String type;
	private String gender;
	private String age;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Trainer(Long id, String name, String type, String gender, String age) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.gender = gender;
		this.age = age;
	}
	
	public Trainer() {}
	
}
